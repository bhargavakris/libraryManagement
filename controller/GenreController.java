package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Genre;
import com.Bhargav.libraryManagement.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public List<Genre> findAllBooks(){
        return genreRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Genre> findBookById(@PathVariable(value = "id") long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        if (genre.isPresent()){
            return ResponseEntity.ok().body(genre.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Genre saveBook(@Validated @RequestBody Genre genre) {
        return genreRepository.save(genre);
    }
}
