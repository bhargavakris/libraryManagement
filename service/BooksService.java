package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Book;

import java.util.List;
import java.util.Optional;

public interface BooksService {

    public List<Book> findAllBooks();

    public Optional<Book> findBookById(Long id);

    public void createBook(Book book);

    public void updateBook(Book book);

    public void deleteBook(Long id);

    public String updateReturnedBookQuantity(List<Long> id);

    public String updateRentedBookQuantity(List<Long> id);
}
