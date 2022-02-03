package com.Bhargav.libraryManagement.repository;

import com.Bhargav.libraryManagement.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bhargava Krishna Dommaraju Venkata
 */
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
