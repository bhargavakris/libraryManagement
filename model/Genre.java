package com.Bhargav.libraryManagement.model;

import javax.persistence.*;

@Table(name = "genre")
@Entity
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(mappedBy = "genre")
    private Book book;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public Genre() {
    }

    public Genre(Long id, String genreName, Book book) {
        this.id = id;
        this.genreName = genreName;
        this.book = book;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genreName='" + genreName + '\'' +
                ", book=" + book +
                '}';
    }
}
