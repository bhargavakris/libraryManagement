package com.Bhargav.libraryManagement.controller;

import com.Bhargav.libraryManagement.model.Genre;
import com.Bhargav.libraryManagement.service.GenreService;
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
    private GenreService genreService;

    @GetMapping
    public List<Genre> findAllGenre(){

        return genreService.findAllGenres();
    }
    @GetMapping("book/{id}")
    public ResponseEntity<Genre> findBookById(@PathVariable(value = "id") long id) {
        Optional<Genre> genre = genreService.findGenreById(id);
        if (genre.isPresent()){
            return ResponseEntity.ok().body(genre.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-Genre")
    public void saveGenre(@Validated @RequestBody Genre genre) {
        genreService.createGenre(genre);
    }

    @PutMapping("/update-Genre/{id}")
    public void updateGenre(@PathVariable(value="id") Long id, @Validated @RequestBody Genre genre){
        Optional<Genre> genreById = genreService.findGenreById(id);
        genreService.updateGenre(genre);
    }
    @DeleteMapping("/remove-Genre/{id}")
    public void deleteGenre(@PathVariable(value = "id") Long id){
        genreService.deleteGenre(id);
    }
}
