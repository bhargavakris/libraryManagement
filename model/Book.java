package com.Bhargav.libraryManagement.model;

import javax.persistence.*;

@Table(name="book")
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="price")
    private String price;

    @Column(name="description")
    private String description;

    @Column(name="author_name")
    private String authorName;

    @ManyToOne
    @JoinColumn(name="author_id",nullable = false)
    private Author author;

    @Column(name="genres")
    private String genres;


    @ManyToMany()
    @JoinTable(name = "Book_genre",
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "genre_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Genre genre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public Book() {
    }

    public Book(Long id, String title, String price, String description, String authorName, Author author, String genres, Genre genre) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.authorName = authorName;
        this.author = author;
        this.genres = genres;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", authorName='" + authorName + '\'' +
                ", author=" + author +
                ", genres='" + genres + '\'' +
                ", genre=" + genre +
                '}';
    }
}
