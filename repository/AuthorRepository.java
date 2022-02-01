package com.Bhargav.libraryManagement.repository;

import com.Bhargav.libraryManagement.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
