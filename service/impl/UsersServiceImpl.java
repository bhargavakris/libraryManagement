package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.model.UserDetails;
import com.Bhargav.libraryManagement.repository.UserDetailsRepository;
import com.Bhargav.libraryManagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Override
    public int findUserLoanedBooks(long id) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        return userDetails.get().getBooksLoaned();
    }

    @Override
    public String updateBooksLoaned(long id, int number) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        userDetails.get().setBooksLoaned(userDetails.get().getBooksLoaned()-number);
        return "you have returned "+number +"of books";
    }

    @Override
    public String updateRentedBooks(long id, int number) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        if(number >3 ){
            return "you cannot rent more than "+number+ " books";
        }
        else if(userDetails.get().getBooksLoaned()!=0){
            return "You cannot loan books at the moment as you have not " +
                    "returned "+userDetails.get().getBooksLoaned()+" books you have taken last time";
        }else{
            userDetails.get().setBooksLoaned(number);
            return "you have rented "+userDetails.get().getBooksLoaned()+" books";
        }

    }
}
