package com.example.controller;

import com.example.dto.OrderDTO;
import com.example.model.mapper.order.OrderMapper;
import com.example.payload.request.order.CreateOrderRequest;
import com.example.payload.response.auth.CustomResponse;
import com.example.payload.response.order.OrderCreatedResponse;
import com.example.payload.response.order.OrderGetResponse;
import com.example.service.OrderSaveService;
import com.example.service.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class OrderController {

    private final OrderService orderService;
    private final OrderSaveService orderSaveService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponse<OrderCreatedResponse> createOrder(@RequestBody CreateOrderRequest createOrderRequest) {

        final OrderDTO orderDTO = orderSaveService.createOrder(createOrderRequest);
        final OrderCreatedResponse response = OrderMapper.toCreatedResponse(orderDTO);
        return CustomResponse.created(response);
    }

    @GetMapping("/{orderId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CUSTOMER')")
    public CustomResponse<OrderGetResponse> getOrderById(@PathVariable Long orderId) {
        final OrderDTO orderDto = orderService.findOrderById(orderId);
        final OrderGetResponse response = OrderMapper.toGetResponse(orderDto);
        return CustomResponse.ok(response);
    }

}
