package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Genre;

import com.Bhargav.libraryManagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersService usersService;

    @GetMapping("/user-loaned-books/{id}")
    public String userLoanedBooks(@PathVariable(value="id") long id ){
        return "No of books You have loaned is: "+usersService.findUserLoanedBooks(id);
    }

    @PutMapping("/return-books/{id}/{number}")
    public String returnedBooks(@PathVariable(value="id") long id, @PathVariable(value ="number")int number){
        return usersService.updateBooksLoaned(id,number)+ "and you need to return"
                +usersService.findUserLoanedBooks(id)+"book";
    }
    @PutMapping("/rent-books/{id}/{number}")
    public String rentBooks(@PathVariable(value="id") long id, @PathVariable(value ="number")int number){
        return usersService.updateRentedBooks(id,number);
    }
}
