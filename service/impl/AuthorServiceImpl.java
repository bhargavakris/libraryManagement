package com.Bhargav.libraryManagement.service.impl;

import com.Bhargav.libraryManagement.model.Author;
import com.Bhargav.libraryManagement.repository.AuthorRepository;
import com.Bhargav.libraryManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);
            authorRepository.deleteById(author.get().getId());
    }
}
