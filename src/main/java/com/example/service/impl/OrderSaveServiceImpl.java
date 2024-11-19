package com.example.service.impl;

import com.example.dto.OrderDTO;
import com.example.dto.OrderItemDTO;
import com.example.exception.user.UserNotFoundException;
import com.example.model.Order;
import com.example.model.User;
import com.example.model.mapper.order.OrderItemMapper;
import com.example.model.mapper.order.OrderMapper;
import com.example.payload.request.order.CreateOrderRequest;
import com.example.repository.OrderRepository;
import com.example.security.CustomUserDetails;
import com.example.service.OrderItemService;
import com.example.service.OrderSaveService;
import com.example.service.UserService;
import com.example.util.Identify;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link OrderSaveService} interface for creating and managing orders.
 */
@Service
@RequiredArgsConstructor
public class OrderSaveServiceImpl implements OrderSaveService {

    private final OrderItemService orderItemService;

    private final UserService userService;

    private final OrderRepository orderRepository;

    private final Identify identify;

    /**
     * Creates a new order based on the provided create order request.
     *
     * @param createOrderRequest The request containing order information to be used for creation.
     * @return An {@link OrderDTO} representing the newly created order.
     */
    @Override
    @Transactional
    public OrderDTO createOrder(CreateOrderRequest createOrderRequest) {

        CustomUserDetails customUserDetails = identify.getCustomUserDetails();

        User user = userService.findByEmail(customUserDetails.getEmail())
                .orElseThrow(() -> new UserNotFoundException(customUserDetails.getId()));

        List<OrderItemDTO> orderItemDTOs = createOrderRequest
                .getOrderDetailSet()
                .stream()
                .map(orderItemService::createOrderItem)
                .toList();

        Order order = Order.builder()
                .user(user)
                .build();

        order.setOrderItems(OrderItemMapper.toOrderItem(orderItemDTOs));

        return OrderMapper.toOrderDTO(orderRepository.save(order));

    }
}
