package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AuthorService {

     List<Author> findAllAuthors();

     ResponseEntity<Author> findAuthorById(Long id);

     ResponseEntity<Author> createAuthor(Author author);

     ResponseEntity<Author> updateAuthor(Long id, Author author);

     ResponseEntity<String> deleteAuthor(Long id);
}
