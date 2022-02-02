package com.Bhargav.libraryManagement.controller;


import com.Bhargav.libraryManagement.service.BooksService;
import com.Bhargav.libraryManagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private BooksService booksService;

    @GetMapping("/user-loaned-books/{id}")
    public String userLoanedBooks(@PathVariable(value="id") Long id ){
        return "No of books You have loaned is: "+usersService.findUserLoanedBooks(id);
    }

    @PutMapping("/return-books/{id}")
    public String returnedBooks(@PathVariable(value="id") Long id,@RequestParam List<Long> bookIds){
        booksService.updateReturnedBookQuantity(bookIds);
        return usersService.updateBooksLoaned(id,bookIds)+ " and you need to return "
                +usersService.findUserLoanedBooks(id)+" book";
    }
    @PutMapping("/rent-books/{id}")
    public String rentBooks(@PathVariable(value="id") Long id, @RequestParam List<Long> bookIds){
        booksService.updateRentedBookQuantity(bookIds);
        return usersService.updateRentedBooks(id,bookIds);
    }
}
