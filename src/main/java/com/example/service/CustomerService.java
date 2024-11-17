package com.example.service;

import com.example.dto.UserDTO;
import com.example.payload.request.customer.CustomerCreateRequest;

/**
 * This interface defines a service for managing customer-related operations.
 */
public interface CustomerService {

    /**
     * Creates a new customer based on the provided customer creation request.
     *
     * @param customerCreateRequest The request containing customer information to be used for creation.
     * @return A {@link UserDTO} representing the newly created customer.
     */
    UserDTO createCustomer(CustomerCreateRequest customerCreateRequest);

}
