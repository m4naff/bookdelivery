package com.example.payload.response.order;

import com.example.dto.OrderItemDTO;
import com.example.dto.UserDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a response object for retrieving orders associated with a customer, containing order details.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderGetByCustomerResponse {

    private Long id;
    private UserDTO user;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> orderItems;

}
