package com.example.service;

import com.example.dto.OrderDTO;
import com.example.payload.request.book.PaginationRequest;
import com.example.payload.request.pagination.PaginatedFindAllRequest;
import org.springframework.data.domain.Page;

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

    /**
     * Retrieves a paginated list of all orders associated with a customer based on their unique identifier.
     *
     * @param customerId The unique identifier of the customer.
     * @param paginationRequest The request containing pagination information.
     * @return A {@link Page} of {@link OrderDTO} objects representing the list of orders for the customer.
     */
    Page<OrderDTO> findAllOrdersByCustomerId(Long customerId, PaginationRequest paginationRequest);

    /**
     * Retrieves a paginated list of all orders within a specified date interval.
     *
     * @param paginatedFindAllRequest The request containing date interval and pagination information.
     * @return A {@link Page} of {@link OrderDTO} objects representing the list of orders within the specified date interval.
     */
    Page<OrderDTO> findAllOrdersBetweenTwoDatesAndPagination(PaginatedFindAllRequest paginatedFindAllRequest);

}
