package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Custom implementation of Spring Security's UserDetailsService interface
 * for loading user details by username during authentication.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Checks if a user with the specified email exists in the database.
     *
     * @param email The email address to check for existence.
     * @return `true` if a user with the given email exists, `false` otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * Retrieves a user by their username.
     *
     * @param username The username of the user to retrieve.
     * @return An Optional containing the User entity if found, or an empty Optional if not found.
     */
    Optional<User> findByUsername(String username);

    /**
     * Retrieves a user by their email address.
     *
     * @param email The email address of the user to retrieve.
     * @return An Optional containing the User entity if found, or an empty Optional if not found.
     */
    Optional<User> findByEmail(String email);
}
