package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.model.UserDetails;
import com.Bhargav.libraryManagement.repository.UserDetailsRepository;
import com.Bhargav.libraryManagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserDetailsRepository userDetailsRepository;
    @Override
    public int findUserLoanedBooks(Long id) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        return userDetails.get().getBooksLoaned();
    }

    @Override
    public String updateBooksLoaned(Long id,List<Long> bookIds) {

        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        userDetails.get().setBooksLoaned(userDetails.get().getBooksLoaned()-bookIds.size());
        userDetailsRepository.save(userDetails.get());
        return "you have returned "+bookIds.size() +" book";
    }

    @Override
    public String updateRentedBooks(Long id, List<Long> bookIds) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        if(bookIds.size() >3 ){
            return "you cannot rent more than "+bookIds.size()+ " books";
        }
        else if(userDetails.get().getBooksLoaned()!=0){
            return "You cannot loan books at the moment as you have not " +
                    "returned "+userDetails.get().getBooksLoaned()+" books you have taken last time";
        }else{
            userDetails.get().setBooksLoaned(bookIds.size());
            userDetailsRepository.save(userDetails.get());
            return "you have rented "+userDetails.get().getBooksLoaned()+" books";
        }

    }
}
