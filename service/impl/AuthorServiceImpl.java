package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.exception.NotFoundException;
import com.Bhargav.libraryManagement.model.Author;
import com.Bhargav.libraryManagement.repository.AuthorRepository;
import com.Bhargav.libraryManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public ResponseEntity<Author> findAuthorById(Long id) {
        Optional<Author> author = Optional.ofNullable(authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id))));
        if (author.isPresent()) {
            return ResponseEntity.ok().body(author.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Author> createAuthor(Author author) {
        authorRepository.save(author);
        return ResponseEntity.accepted().body(author);
    }

    public ResponseEntity<Author> updateAuthor(Long id, Author author) {
        Optional<Author> authorById = Optional.ofNullable(authorRepository.findById(id))
                .orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));
        if (authorById.isPresent()) {
            authorRepository.save(author);
            return ResponseEntity.ok().body(authorById.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    public ResponseEntity<String> deleteAuthor(Long id) {
        Optional<Author> author = Optional.ofNullable(authorRepository.findById(id))
                .orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));
        if (author.isPresent()) {
            authorRepository.deleteById(id);
            return ResponseEntity.ok("Deleted the Author with Id: " + id + " Successfully ");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
