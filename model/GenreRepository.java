package com.Bhargav.libraryManagement.model;

import com.Bhargav.libraryManagement.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
