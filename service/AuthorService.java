package com.Bhargav.libraryManagement.service;

import com.Bhargav.libraryManagement.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    public List<Author> findAllAuthors();
    public Optional<Author> findAuthorById(Long id);
    public void createAuthor(Author author);
    public void updateAuthor(Author author);
    public void deleteAuthor(Long id);
}
