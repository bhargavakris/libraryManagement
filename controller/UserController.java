package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.model.UserDetails;
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

    @GetMapping("/{id}")
    public UserDetails findUserById(@PathVariable(value = "id") long id) {
        return usersService.findUserById(id);
    }
    @GetMapping("/user-loaned-books/{id}")
    public Book userLoanedBooks(@PathVariable(value="id") Long id ){
        return usersService.findUserLoanedBooks(id);
    }

    @PutMapping("/return-books/{id}")
    public String returnedBooks(@PathVariable(value="id") Long id,@RequestParam List<Long> bookIds){

        return booksService.updateReturnedBookQuantity(bookIds) + usersService.updateBooksReturned(id,bookIds)+
                " and you need to return "
                +usersService.findUserLoanedBooks(id)+" book";
    }
    @PutMapping("/rent-books/{id}")
    public String rentBooks(@PathVariable(value="id") Long id, @RequestParam List<Long> bookIds){

        return booksService.updateRentedBookQuantity(bookIds) +usersService.updateRentedBooks(id,bookIds);
    }
}
