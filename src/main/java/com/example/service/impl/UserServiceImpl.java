package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This class implements the UserService interface.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Finds a user by their username.
     *
     * @param username The username to search for.
     * @return An {@link Optional} containing the {@link User} if found, or an empty {@link Optional} if not found.
     */
    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Finds a user by their unique identifier.
     *
     * @param userId The unique identifier of the user.
     * @return An {@link Optional} containing the {@link User} if found, or an empty {@link Optional} if not found.
     */
    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    /**
     * Finds a user by their email address.
     *
     * @param email The email address to search for.
     * @return An {@link Optional} containing the {@link User} if found, or an empty {@link Optional} if not found.
     */
    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
