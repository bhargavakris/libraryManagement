package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Author;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public List<Author> findAllAuthors();
    public ResponseEntity<Author> findAuthorById(Long id);
    public ResponseEntity<Author> createAuthor(Author author);
    public ResponseEntity<Author> updateAuthor(Long id,Author author);
    public ResponseEntity<String> deleteAuthor(Long id);
}
