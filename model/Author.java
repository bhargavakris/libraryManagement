package com.Bhargav.libraryManagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "author")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_author_book", referencedColumnName = "id")
    private Set<Book> books = new HashSet<>();
}
