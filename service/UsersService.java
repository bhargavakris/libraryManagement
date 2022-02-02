package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.model.UserDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface UsersService {

     ResponseEntity<Set<Book>> findUserLoanedBooks(Long id);

     ResponseEntity<UserDetails> findUserById(Long id);

     ResponseEntity<String> updateBooksReturned(Long id, List<Long> bookIds);

     ResponseEntity<String> updateRentedBooks(Long id, List<Long> bookIds);

}
