package com.example.model.mapper.order;

import com.example.dto.OrderDTO;
import com.example.model.Order;
import com.example.model.mapper.user.UserMapper;
import com.example.payload.response.CustomPageResponse;
import com.example.payload.response.order.OrderCreatedResponse;
import com.example.payload.response.order.OrderGetByCustomerResponse;
import com.example.payload.response.order.OrderGetResponse;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;

/**
 * Utility class for mapping operations related to {@link Order} and {@link OrderDTO}.
 */
@UtilityClass
public class OrderMapper {

    /**
     * Converts an {@link Order} object to an {@link OrderDTO}.
     *
     * @param source The {@link Order} object to be converted.
     * @return An {@link OrderDTO} containing data from the source object.
     */
    public static OrderDTO toOrderDTO(Order source) {
        return OrderDTO.builder()
                .id(source.getId())
                .user(UserMapper.toDTO(source.getUser()))
                .orderItems(OrderItemMapper.toDTO(source.getOrderItems()))
                .createdAt(source.getCreatedAt())
                .build();
    }

    /**
     * Converts an {@link OrderDTO} object to an {@link OrderCreatedResponse}.
     *
     * @param orderDTO The {@link OrderDTO} object to be converted.
     * @return An {@link OrderCreatedResponse} containing data from the source DTO.
     */
    public static OrderCreatedResponse toCreatedResponse(OrderDTO orderDTO) {
        return OrderCreatedResponse.builder()
                .id(orderDTO.getId())
                .user(orderDTO.getUser())
                .createdAt(orderDTO.getCreatedAt())
                .orderItems(orderDTO.getOrderItems())
                .build();
    }

    /**
     * Converts an {@link OrderDTO} object to an {@link OrderGetResponse}.
     *
     * @param source The {@link OrderDTO} object to be converted.
     * @return An {@link OrderGetResponse} containing data from the source DTO.
     */
    public static OrderGetResponse toGetResponse(OrderDTO source) {
        return OrderGetResponse.builder()
                .id(source.getId())
                .user(source.getUser())
                .orderItems(source.getOrderItems())
                .createdAt(source.getCreatedAt())
                .build();
    }

    /**
     * Converts an {@link OrderDTO} object to an {@link OrderGetByCustomerResponse}.
     *
     * @param source The {@link OrderDTO} object to be converted.
     * @return An {@link OrderGetByCustomerResponse} containing data from the source DTO.
     */
    public static OrderGetByCustomerResponse toGetByCustomerResponse(OrderDTO source) {
        return OrderGetByCustomerResponse.builder()
                .id(source.getId())
                .user(source.getUser())
                .orderItems(source.getOrderItems())
                .createdAt(source.getCreatedAt())
                .build();
    }

    /**
     * Converts a {@link Page<OrderDTO>} to a {@link CustomPageResponse<OrderGetByCustomerResponse>}.
     *
     * @param sources The source {@link Page<OrderDTO>} to be converted.
     * @return A {@link CustomPageResponse<OrderGetByCustomerResponse>} containing converted data.
     */
    public static CustomPageResponse<OrderGetByCustomerResponse> toGetByCustomerResponse(Page<OrderDTO> sources) {
        return CustomPageResponse.of(sources.map(OrderMapper::toGetByCustomerResponse));
    }
}
