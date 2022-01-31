package com.Bhargav.libraryManagement.model;

import com.Bhargav.libraryManagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
