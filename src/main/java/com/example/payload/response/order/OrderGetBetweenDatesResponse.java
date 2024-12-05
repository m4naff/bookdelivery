package com.example.payload.response.order;

import com.example.dto.OrderItemDTO;
import com.example.dto.UserDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a response object for retrieving orders within a date range, containing order details.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderGetBetweenDatesResponse {

    private Long id;
    private UserDTO user;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> orderItems;

}
