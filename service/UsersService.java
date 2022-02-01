package com.Bhargav.libraryManagement.service;

public interface UsersService {

    public int findUserLoanedBooks(long id);

    public String updateBooksLoaned(long id,int number);
    public String updateRentedBooks(long id,int number);

}
