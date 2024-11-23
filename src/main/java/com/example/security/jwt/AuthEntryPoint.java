package com.example.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom implementation of Spring Security's AuthenticationEntryPoint interface
 * for handling unauthorized access and returning appropriate error responses.
 */
@Component
public class AuthEntryPoint implements AuthenticationEntryPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthEntryPoint.class);

    /**
     * Commences the authentication process when an unauthorized request is made.
     *
     * @param request        The HttpServletRequest representing the incoming request.
     * @param response       The HttpServletResponse for sending the error response.
     * @param authException  The AuthenticationException indicating the unauthorized access.
     * @throws IOException      If there's an I/O error while writing the error response.
     * @throws ServletException If there's a servlet-related exception.
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        LOGGER.error("AuthEntryPoint | commence | Unauthorized error: {}", authException.getMessage());

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        body.put("error", "Unauthorized");
        body.put("message", authException.getMessage());
        body.put("path", request.getServletPath());


        LOGGER.info("AuthEntryPoint | commence | status: {}", HttpServletResponse.SC_UNAUTHORIZED);
        LOGGER.info("AuthEntryPoint | commence | error: {}", "Unauthorized");
        LOGGER.info("AuthEntryPoint | commence | message: {}", authException.getMessage());
        LOGGER.info("AuthEntryPoint | commence | path: {}", request.getServletPath());

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), body);
    }
}
