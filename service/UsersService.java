package com.Bhargav.libraryManagement.service;

import java.util.List;

public interface UsersService {

    public int findUserLoanedBooks(Long id);

    public String updateBooksLoaned(Long id, List<Long> bookIds);
    public String updateRentedBooks(Long id, List<Long> bookIds);

}
