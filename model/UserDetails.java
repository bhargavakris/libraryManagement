package com.Bhargav.libraryManagement.model;

import lombok.*;
import javax.persistence.*;

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
        private Long id;

        @Column(name = "user_name")
        private String name;

        @Column(name="no_of_books_loaned")
        private int booksLoaned;
    }

