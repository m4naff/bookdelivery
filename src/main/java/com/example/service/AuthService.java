package com.example.service;

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


}
