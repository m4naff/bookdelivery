package com.example.security.jwt;

import com.example.model.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serial;

/**
 * Custom implementation of Spring Security's UserDetails interface for handling user authentication and authorization.
 */
@Getter
@RequiredArgsConstructor
public class CustomUserDetails {

    @Serial
    private static final long serialVersionUID = 4514751530271704280L;

    private final User user;



}
