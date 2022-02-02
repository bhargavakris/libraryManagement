package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Genre;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GenreService {

    public List<Genre> findAllGenres();

    public ResponseEntity<Genre> findGenreById(Long id);

    public ResponseEntity<Genre> createGenre(Genre genre);

    public ResponseEntity<Genre> updateGenre(Long id, Genre genre);

    public ResponseEntity<String> deleteGenre(Long id);
}
