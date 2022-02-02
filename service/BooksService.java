package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    public List<Book> findAllBooks();

    public ResponseEntity<Book> findBookById(Long id);

    public ResponseEntity<Book> createBook(Book book);

    public ResponseEntity<Book> updateBook(Long id,Book book);

    public ResponseEntity<String> deleteBook(Long id);

    public String updateReturnedBookQuantity(List<Long> id);

    public List<String> updateRentedBookQuantity(List<Long> bookId);
}
