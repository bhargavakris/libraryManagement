package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {

    List<Genre> findAllGenres();

    ResponseEntity<Genre> findGenreById(Long id);

    ResponseEntity<Genre> createGenre(Genre genre);

    ResponseEntity<Genre> updateGenre(Long id, Genre genre);

    ResponseEntity<String> deleteGenre(Long id);
}
