package com.Bhargav.libraryManagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "book")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "genres")
    private String genres;

    @Column(name = "quantity")
    private int quantity = 1;


    @ManyToMany()
    @JoinTable(name = "Book_genre",
            joinColumns = {
                    @JoinColumn(name = "book_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "genre_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private Set<Genre> genre = new HashSet<>();

}
