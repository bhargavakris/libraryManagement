package com.Bhargav.libraryManagement.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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

        @Column(name="email_id")
        private String emailId;

        @Column(name="no_of_books_loaned")
        @Min(0)
        @Max(3)
        private int booksLoaned;
    }

