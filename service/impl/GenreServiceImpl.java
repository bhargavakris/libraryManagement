package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.model.Genre;
import com.Bhargav.libraryManagement.repository.GenreRepository;
import com.Bhargav.libraryManagement.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Genre> findGenreById(Long id) {
        return genreRepository.findById(id);
    }

    public void createGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(Long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        genreRepository.deleteById(genre.get().getId());
    }
}
