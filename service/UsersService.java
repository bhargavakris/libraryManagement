package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.model.UserDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UsersService {

    public ResponseEntity<Set<Book>> findUserLoanedBooks(Long id);
    public ResponseEntity<UserDetails> findUserById(Long id);
    public String updateBooksReturned(Long id, List<Long> bookIds);
    public String updateRentedBooks(Long id, List<Long> bookIds);

}
