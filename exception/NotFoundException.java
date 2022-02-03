package com.Bhargav.libraryManagement.exception;

/**
 * Exception to be thrown if details are not found
 *
 * @author Bhargava Krishna Dommaraju Venkata
 */
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

}