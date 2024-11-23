package com.example.controller;

import com.example.payload.request.auth.LoginRequest;
import com.example.payload.request.auth.SignUpRequest;
import com.example.payload.request.auth.TokenRefreshRequest;
import com.example.payload.response.auth.CustomResponse;
import com.example.payload.response.auth.JWTResponse;
import com.example.payload.response.auth.TokenRefreshResponse;
import com.example.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponse<String> register(@RequestBody SignUpRequest request) {

        return CustomResponse.created(authService.register(request));
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public CustomResponse<JWTResponse> login(@RequestBody LoginRequest request) {

        return CustomResponse.ok(authService.login(request));
    }

    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public CustomResponse<TokenRefreshResponse> refreshToken(@RequestBody TokenRefreshRequest request) {

        return CustomResponse.ok(authService.refreshToken(request));
    }

    @PostMapping("/logout")
    @ResponseStatus(HttpStatus.OK)
    public CustomResponse<String> logout(@RequestHeader("Authorization") String token) {

        return CustomResponse.ok(authService.logout(token));
    }

}
