package com.example.service.impl;

import com.example.dto.OrderDTO;
import com.example.exception.order.OrderNotFoundException;
import com.example.model.enums.Role;
import com.example.model.mapper.order.OrderMapper;
import com.example.payload.request.book.PaginationRequest;
import com.example.payload.request.pagination.PaginatedFindAllRequest;
import com.example.repository.OrderRepository;
import com.example.security.CustomUserDetails;
import com.example.service.OrderService;
import com.example.util.Identify;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link OrderService} interface for managing orders.
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final Identify identify;

    /**
     * Retrieves an order by its unique identifier.
     *
     * @param id The unique identifier of the order.
     * @return An {@link OrderDTO} representing the order with the specified ID.
     */
    @Override
    public OrderDTO findOrderById(Long id) {
        CustomUserDetails userDetails = identify.getCustomUserDetails();

        return orderRepository.findById(id)
                .map(order -> {
                    // Check access based on customUserDetails here
                    if (userDetails.getId().equals(order.getUser().getId()) &&
                        userDetails.getUser().getRole().equals(Role.ROLE_CUSTOMER)
                        || userDetails.getUser().getRole().equals(Role.ROLE_ADMIN)) {
                            return OrderMapper.toOrderDTO(order);
                        } else {
                            throw new AccessDeniedException("You cannot access this order by Id");
                        }
                })
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
    }

    @Override
    public Page<OrderDTO> findAllOrdersByCustomerId(Long customerId, PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public Page<OrderDTO> findAllOrdersBetweenTwoDatesAndPagination(PaginatedFindAllRequest paginatedFindAllRequest) {
        return null;
    }
}
