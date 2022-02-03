package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Author;
import com.Bhargav.libraryManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API'S to find, create,update and delete author details
 *
 * @author Bhargava Krishna Dommaraju Venkata
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable(value = "id") long id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping("/add-author")
    public ResponseEntity<Author> saveAuthor(@Validated @RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/update-author/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable(value = "id") Long id, @Validated @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/remove-author/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable(value = "id") Long id) {
        return authorService.deleteAuthor(id);
    }
}
