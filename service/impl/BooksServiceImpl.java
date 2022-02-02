package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.repository.BookRepository;
import com.Bhargav.libraryManagement.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    private final int zero=0;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        bookRepository.deleteById(book.get().getId());
    }

    public String updateReturnedBookQuantity(List<Long> bookIds) {
        for (Long id : bookIds) {
            Optional<Book> book = bookRepository.findById(id);
            if (book.get().getQuantity() == 0) {
                book.get().setQuantity(1);
            }
        }
        return "You have returned all the books";
    }

    public String updateRentedBookQuantity(List<Long> bookIds) {
        for (Long id : bookIds) {
            Optional<Book> book = bookRepository.findById(id);
            if (book.get().getQuantity() == zero) {
                return "The book is not available at the moment come back after sometime";
            } else {
                book.get().setQuantity(zero);
                return "the book has been returned successfully";
            }
        }
        return null;
    }
}
