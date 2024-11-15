package com.example.payload.response.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a response object containing a JWT token and related information.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JWTResponse {

    private String token;

    @Builder.Default
    private String type = "Bearer";
    private String refreshToken;
    private String email;

}
