package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.exception.NotFoundException;
import com.Bhargav.libraryManagement.model.Genre;
import com.Bhargav.libraryManagement.repository.GenreRepository;
import com.Bhargav.libraryManagement.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    public ResponseEntity<Genre> findGenreById(Long id) {
        Optional<Genre> genre = Optional.ofNullable(genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id))));
        return genre.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Genre> createGenre(Genre genre) {
        genreRepository.save(genre);
        return ResponseEntity.accepted().body(genre);
    }

    public ResponseEntity<Genre> updateGenre(Long id, Genre genre) {
        Optional<Genre> genreById = Optional.ofNullable(genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id))));
        if (genreById.isPresent()) {
            genreRepository.save(genre);
            return ResponseEntity.accepted().body(genre);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deleteGenre(Long id) {
        Optional<Genre> genreById = Optional.ofNullable(genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id))));
        if (genreById.isPresent()) {
            genreRepository.deleteById(id);
            return ResponseEntity.ok("Deleted the Genre with Id: " + id + " successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
