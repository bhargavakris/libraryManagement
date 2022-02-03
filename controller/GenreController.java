package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Genre;
import com.Bhargav.libraryManagement.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API'S to find, create,update and delete Genre details
 *
 * @author Bhargava Krishna Dommaraju Venkata
 */
@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public List<Genre> findAllGenre() {
        return genreService.findAllGenres();
    }

    @GetMapping("book/{id}")
    public ResponseEntity<Genre> findBookById(@PathVariable(value = "id") long id) {
        return genreService.findGenreById(id);
    }

    @PostMapping("/add-Genre")
    public ResponseEntity<Genre> saveGenre(@Validated @RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }

    @PutMapping("/update-Genre/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable(value = "id") Long id, @Validated @RequestBody Genre genre) {
        return genreService.updateGenre(id, genre);
    }

    @DeleteMapping("/remove-Genre/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable(value = "id") Long id) {
        return genreService.deleteGenre(id);
    }
}
