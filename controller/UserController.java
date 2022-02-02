package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.model.UserDetails;
import com.Bhargav.libraryManagement.service.BooksService;
import com.Bhargav.libraryManagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private BooksService booksService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetails> findUserById(@PathVariable(value = "id") long id) {
        return usersService.findUserById(id);
    }

    @GetMapping("/user-loaned-books/{id}")
    public ResponseEntity<Set<Book>> userLoanedBooks(@PathVariable(value = "id") Long id) {
        return usersService.findUserLoanedBooks(id);
    }

    @PutMapping("/return-books/{id}")
    public ResponseEntity<String> returnedBooks(@PathVariable(value = "id") Long id, @RequestParam List<Long> bookIds) {
        return usersService.updateBooksReturned(id, bookIds);
    }

    @PutMapping("/rent-books/{id}")
    public ResponseEntity<String> rentBooks(@PathVariable(value = "id") Long id, @RequestParam List<Long> bookIds) {
        return usersService.updateRentedBooks(id, bookIds);
    }
}
