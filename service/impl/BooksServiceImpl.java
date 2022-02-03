package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.exception.NotFoundException;
import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.repository.BookRepository;
import com.Bhargav.libraryManagement.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Bhargava Krishna Dommaraju Venkata
 */
@Service
public class BooksServiceImpl implements BooksService {

    private final int zero = 0;
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public ResponseEntity<Book> findBookById(Long id) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id))));
        return book.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Book> createBook(Book book) {
        bookRepository.save(book);
        return ResponseEntity.accepted().body(book);
    }

    public ResponseEntity<Book> updateBook(Long id, Book book) {
        Optional<Book> bookById = Optional.ofNullable(bookRepository.findById(id))
                .orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));
        if (bookById.isPresent()) {
            bookRepository.save(book);
            return ResponseEntity.ok().body(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteBook(Long id) {
        Optional<Book> book = Optional.ofNullable(bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id))));
        if (book.isPresent()) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Deleted the book with Id: " + id + " Successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public String updateReturnedBookQuantity(List<Long> bookIds) {
        for (Long id : bookIds) {
            Optional<Book> book = Optional.ofNullable(bookRepository.findById(id)
                    .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id))));
            if (book.get().getQuantity() == zero) {
                book.get().setQuantity(1);
            }
        }
        return "You have returned all the books";
    }

    public List<String> updateRentedBookQuantity(List<Long> bookIds) {
        List<String> returnValue = null;

        if (bookIds.size() > 3) {
            returnValue.add("You cannot take more than 3 books ata time");
        } else {
            for (Long bookId : bookIds) {
                Optional<Book> book = Optional.ofNullable(bookRepository.findById(bookId)
                        .orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", bookId))));
                if (book.get().getQuantity() == zero) {
                    returnValue.add(String.format("The book with ID %d is not available at the moment come back after sometime", bookId));
                } else {
                    book.get().setQuantity(zero);
                    returnValue.add(String.format("The book with ID %d has been rented successfully", bookId));
                }
            }
        }
        return returnValue;
    }
}
