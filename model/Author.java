package com.Bhargav.libraryManagement.model;

import javax.persistence.*;

@Table(name = "author")
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(mappedBy = "author")
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Author() {
    }

    public Author(Long id, String authorName, Book book) {
        this.id = id;
        this.authorName = authorName;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", book=" + book +
                '}';
    }
}
