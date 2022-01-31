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
    private Long id;

    @Column(name = "author_name")
    private String authorName;

    @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
    @JoinColumn(name="ab_fk", referencedColumnName = "id")
    private Set<Book> books = new HashSet<>();
}
