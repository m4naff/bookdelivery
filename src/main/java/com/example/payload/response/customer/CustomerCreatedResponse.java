package com.example.payload.response.customer;

import lombok.*;

/**
 * Represents a response object for customer creation, containing customer details.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCreatedResponse {

    private Long id;

    private String fullName;

    private String username;

    private String email;

}
