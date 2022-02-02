package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BooksService {

    List<Book> findAllBooks();

    ResponseEntity<Book> findBookById(Long id);

    ResponseEntity<Book> createBook(Book book);

    ResponseEntity<Book> updateBook(Long id, Book book);

    ResponseEntity<String> deleteBook(Long id);

    String updateReturnedBookQuantity(List<Long> id);

    List<String> updateRentedBookQuantity(List<Long> bookId);
}
