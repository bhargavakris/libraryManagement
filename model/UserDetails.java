package com.Bhargav.libraryManagement.model;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "userDetails")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
        @Id
        @GeneratedValue
        private long id;

        @Column(name = "user_name")
        private String name;

        @Column(name="email_id")
        private String emailId;

        @Column(name="no_of_books_loaned")
        private int booksLoaned;

        @OneToMany(targetEntity = Book.class,cascade = CascadeType.ALL)
        @JoinColumn(name="fk_user_book", referencedColumnName = "id")
        private Set<Book> books = new HashSet<>();
    }

