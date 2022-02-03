package com.Bhargav.libraryManagement.repository;

import com.Bhargav.libraryManagement.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bhargava Krishna Dommaraju Venkata
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
