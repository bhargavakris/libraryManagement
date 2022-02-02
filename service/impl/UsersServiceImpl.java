package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.exception.NotFoundException;
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
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
        return userDetails.map(UserDetails::getBooksLoaned).orElse(0);
    }

    @Override
    public String updateBooksLoaned(Long id,List<Long> bookIds) {

        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("User not found with ID %d", id))));
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
            userDetails.ifPresent(details -> details.setBooksLoaned(bookIds.size()));
            userDetailsRepository.save(userDetails.get());
            return "you have rented "+userDetails.get().getBooksLoaned()+" books";
        }

    }
}
