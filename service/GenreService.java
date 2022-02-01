package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Genre;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GenreService {

    public List<Genre> findAllGenres();

    public Optional<Genre> findGenreById(Long id);

    public void createGenre(Genre genre);

    public void updateGenre(Genre genre);

    public void deleteGenre(Long id);
}
