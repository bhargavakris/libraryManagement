package com.Bhargav.libraryManagement.repository;

import com.Bhargav.libraryManagement.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bhargava Krishna Dommaraju Venkata
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
