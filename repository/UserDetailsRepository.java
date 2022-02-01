package com.Bhargav.libraryManagement.repository;

import com.Bhargav.libraryManagement.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
