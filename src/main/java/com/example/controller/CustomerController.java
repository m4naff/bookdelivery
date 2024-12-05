package com.example.controller;

import com.example.dto.UserDTO;
import com.example.model.mapper.customer.CustomerMapper;
import com.example.payload.request.customer.CustomerCreateRequest;
import com.example.payload.response.auth.CustomResponse;
import com.example.payload.response.customer.CustomerCreatedResponse;
import com.example.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class CustomerController {

    private final CustomerService customerService;

    /**
     * Creates a new {@link User} in Customer Role
     * Only admins can access.
     *
     * @param customerCreateRequest {@link CustomerCreateRequest}
     * @return Response entity of {@link CustomerCreatedResponse}
     */
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponse<CustomerCreatedResponse> createCustomer(
            @RequestBody @Valid final CustomerCreateRequest customerCreateRequest
            ) {

        final UserDTO createdUser = customerService.createCustomer(customerCreateRequest);
        final CustomerCreatedResponse createdResponse = CustomerMapper.toCreatedResponse(createdUser);

        return CustomResponse.created(createdResponse);
    }

}
