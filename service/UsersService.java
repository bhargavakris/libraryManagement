package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    public Book findUserLoanedBooks(Long id);
    public UserDetails findUserById(Long id);
    public String updateBooksReturned(Long id, List<Long> bookIds);
    public String updateRentedBooks(Long id, List<Long> bookIds);

}
