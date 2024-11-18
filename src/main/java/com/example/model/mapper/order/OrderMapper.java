package com.example.model.mapper.order;

import com.example.dto.OrderDTO;
import com.example.model.Order;
import com.example.model.mapper.user.UserMapper;
import lombok.experimental.UtilityClass;

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
}
