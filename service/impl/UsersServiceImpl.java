package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.exception.NotFoundException;
import com.Bhargav.libraryManagement.model.Book;
import com.Bhargav.libraryManagement.model.UserDetails;
import com.Bhargav.libraryManagement.repository.BookRepository;
import com.Bhargav.libraryManagement.repository.UserDetailsRepository;
import com.Bhargav.libraryManagement.service.BooksService;
import com.Bhargav.libraryManagement.service.UsersService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book findUserLoanedBooks(Long id) {
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        return (Book) userDetails.get().getBooks();
    }

    @Override
    public UserDetails findUserById(Long id) {
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        return userDetails.get();
    }

    @Override
    public String updateBooksReturned(Long id,List<Long> bookIds) {

        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        for(Long bookId: bookIds){
            Optional<Book> book = Optional.ofNullable( bookRepository.findById(bookId)
                    .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", bookId))));
            JSONObject json = new JSONObject((Map) userDetails.get());
            json.remove(String.valueOf(book));
        }
        userDetails.ifPresent(details -> details.setBooksLoaned(details.getBooksLoaned() - bookIds.size()));
        userDetailsRepository.save(userDetails.get());

        return "you have returned "+bookIds.size() +" book";
    }

    @Override
    public String updateRentedBooks(Long id, List<Long> bookIds) {
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        if(bookIds.size() >3 ){
            return "you cannot rent more than "+bookIds.size()+ " books";
        }
        else if(userDetails.get().getBooksLoaned()!=0){
            return "You cannot loan books at the moment as you have not " +
                    "returned "+userDetails.get().getBooksLoaned()+" books you have taken last time";
        }else{
            for(Long bookId: bookIds){
                Optional<Book> book = Optional.ofNullable( bookRepository.findById(bookId)
                        .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", bookId))));
                userDetails.get().setBooks((Set<Book>) book.get());
            }
            userDetails.ifPresent(details -> details.setBooksLoaned(bookIds.size()));
            userDetailsRepository.save(userDetails.get());
            return "you have rented "+userDetails.get().getBooksLoaned()+" books";
        }

    }
}
