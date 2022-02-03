package com.Bhargav.libraryManagement.repository;

import com.Bhargav.libraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bhargava Krishna Dommaraju Venkata
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
