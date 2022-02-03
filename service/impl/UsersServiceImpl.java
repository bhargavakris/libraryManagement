package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.exception.NotFoundException;
import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.model.UserDetails;
import com.Bhargav.libraryManagement.repository.BookRepository;
import com.Bhargav.libraryManagement.repository.UserDetailsRepository;
import com.Bhargav.libraryManagement.service.UsersService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public ResponseEntity<Set<Book>> findUserLoanedBooks(Long id) {
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        if (userDetails.isPresent()) {
            return ResponseEntity.ok().body(userDetails.get().getBooks());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<UserDetails> findUserById(Long id) {
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        if (userDetails.isPresent()) {
            return ResponseEntity.ok().body(userDetails.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> updateBooksReturned(Long id, List<Long> bookIds) {

        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        if (userDetails.isPresent()) {
            Set<Book> books = userDetails.get().getBooks();
            for (Long bookId : bookIds) {
                Optional<Book> book = Optional.ofNullable(bookRepository.findById(bookId)
                        .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", bookId))));
               if(book.isPresent() && books.contains(book.get())){
                   books.remove(book.get());
               }else{
                   return ResponseEntity.ok("The book with book Id: "+bookId+" is not rented by the user");
               }
            }
            userDetails.get().setBooks(books);
            userDetails.ifPresent(details -> details.setBooksLoaned(details.getBooksLoaned() - bookIds.size()));
            userDetailsRepository.save(userDetails.get());
            return ResponseEntity.ok("you have returned " + bookIds.size() + " book");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<String> updateRentedBooks(Long id, List<Long> bookIds) {
        Set<Book> books = new HashSet<>();
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        if (bookIds.size() > 3) {
            return ResponseEntity.ok("you cannot rent more than " + bookIds.size() + " books");
        } else if (userDetails.isPresent())
            if (userDetails.get().getBooksLoaned() != 0) {
                return ResponseEntity.ok("You cannot loan books at the moment as you have not " +
                        "returned " + userDetails.get().getBooksLoaned() + " books you have taken last time");
            } else {
                for (Long bookId : bookIds) {
                    Optional<Book> book = Optional.ofNullable(bookRepository.findById(bookId)
                            .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", bookId))));
                    if(book.isPresent() && book.get().getQuantity()==0){
                        return ResponseEntity.ok("The book with Book Id: "+bookId+" is not available at the moment");
                    }else {
                        books.add(book.get());
                    }
                }
                userDetails.get().setBooks(books);
                userDetails.ifPresent(details -> details.setBooksLoaned(bookIds.size()));
                userDetailsRepository.save(userDetails.get());
                return ResponseEntity.ok("you have rented " + userDetails.get().getBooksLoaned() + " books");
            }
        else {
            return ResponseEntity.notFound().build();
        }

    }
}
