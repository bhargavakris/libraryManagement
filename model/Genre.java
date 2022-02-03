package com.Bhargav.libraryManagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Book Details
 *
 * @author Bhargava Krishna Dommaraju Venkata
 */
@Table(name = "genre")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "genre_name")
    private String genreName;

    @ManyToMany(mappedBy = "genre")
    private Set<Book> book = new HashSet<>();
}
