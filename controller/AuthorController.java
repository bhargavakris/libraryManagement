package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Author;
import com.Bhargav.libraryManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/authors")
    public List<Author> findAllAuthors(){
        return authorService.findAllAuthors();
    }
    @GetMapping("/{id}")
    public Optional<Author> findAuthorById(@PathVariable(value = "id") long id) {
       return authorService.findAuthorById(id);
    }

    @PostMapping("/add-author")
    public void saveAuthor(@Validated @RequestBody Author author) {
         authorService.createAuthor(author);
    }
    @PutMapping("/update-author/{id}")
    public void updateAuthor(@PathVariable(value="id") Long id, @Validated @RequestBody Author author){
        Optional<Author> authorById = authorService.findAuthorById(id);
        authorService.updateAuthor(author);
    }
    @DeleteMapping("/remove-author/{id}")
    public void deleteAuthor(@PathVariable(value = "id") Long id){
        authorService.deleteAuthor(id);
    }
}
