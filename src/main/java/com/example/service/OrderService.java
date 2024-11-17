package com.example.service;

import com.example.dto.OrderDTO;

/**
 * This interface defines a service for managing order-related operations.
 */
public interface OrderService {

    /**
     * Retrieves an order by its unique identifier.
     *
     * @param id The unique identifier of the order.
     * @return An {@link OrderDTO} representing the order with the specified ID.
     */
    OrderDTO findOrderById(Long id);



}
