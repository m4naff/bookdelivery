package com.example.service.impl;

import com.example.exception.user.EmailAlreadyExistsException;
import com.example.payload.request.auth.LoginRequest;
import com.example.payload.request.auth.SignUpRequest;
import com.example.payload.request.auth.TokenRefreshRequest;
import com.example.payload.response.auth.JWTResponse;
import com.example.payload.response.auth.TokenRefreshResponse;
import com.example.repository.UserRepository;
import com.example.security.jwt.JwtUtils;
import com.example.service.AuthService;
import com.example.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service implementation for handling authentication-related operations.
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;

    private final RefreshTokenService refreshTokenService;

    private final JwtUtils jwtUtils;

    /**
     * Registers a new user based on the provided signup request.
     *
     * @param request The signup request containing user registration information.
     * @return A string representing the result of the registration process.
     */
    @Override
    public String register(SignUpRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }
    }

    @Override
    public JWTResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public TokenRefreshResponse refreshToken(TokenRefreshRequest request) {
        return null;
    }

    @Override
    public String logout(String token) {
        return "";
    }
}
