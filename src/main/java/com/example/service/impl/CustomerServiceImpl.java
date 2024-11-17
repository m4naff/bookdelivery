package com.example.service.impl;

import com.example.dto.UserDTO;
import com.example.exception.user.EmailAlreadyExistsException;
import com.example.model.User;
import com.example.model.enums.Role;
import com.example.model.mapper.user.UserMapper;
import com.example.payload.request.customer.CustomerCreateRequest;
import com.example.repository.UserRepository;
import com.example.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link CustomerService} interface for creating and managing customer accounts.
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    /**
     * Creates a new customer based on the provided customer creation request.
     *
     * @param customerCreateRequest The request containing customer information to be used for creation.
     * @return A {@link User} representing the newly created customer.
     */
    @Override
    public UserDTO createCustomer(CustomerCreateRequest customerCreateRequest) {
        if (userRepository.existsByEmail(customerCreateRequest.getEmail())) {
            throw new EmailAlreadyExistsException(customerCreateRequest.getEmail());
        }

        User user = User.builder()
                .email(customerCreateRequest.getEmail())
                .fullName(customerCreateRequest.getFullName())
                .username(customerCreateRequest.getUsername())
                .password(passwordEncoder.encode(customerCreateRequest.getPassword()))
                .role(Role.ROLE_CUSTOMER)
                .build();

        return UserMapper.toDTO(userRepository.save(user));
    }
}
