package com.example.service;

import com.example.payload.request.auth.LoginRequest;
import com.example.payload.request.auth.SignUpRequest;
import com.example.payload.response.auth.JWTResponse;

/**
 * This interface defines authentication and authorization services.
 */
public interface AuthService {

    /**
     * Registers a new user based on the provided signup request.
     *
     * @param request The signup request containing user registration information.
     * @return A string representing the result of the registration process.
     */
    String register(SignUpRequest request);

    /**
     * Logs a user in using the provided login credentials.
     *
     * @param request The login request containing user login credentials.
     * @return A {@link JWTResponse} containing a JWT token and related information upon successful login.
     */
    JWTResponse login(LoginRequest request);


}
