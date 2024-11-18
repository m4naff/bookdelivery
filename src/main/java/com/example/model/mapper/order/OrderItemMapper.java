package com.example.model.mapper.order;

import com.example.dto.OrderItemDTO;
import com.example.model.Book;
import com.example.model.OrderItem;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * Utility class for mapping operations related to {@link OrderItem} and {@link OrderItemDTO}.
 */
@UtilityClass
public class OrderItemMapper {

    /**
     * Converts an {@link OrderItem} object to an {@link OrderItemDTO}.
     *
     * @param orderItem The {@link OrderItem} object to be converted.
     * @return An {@link OrderItemDTO} containing data from the source object.
     */
    public OrderItemDTO toDTO(OrderItem orderItem) {
        return OrderItemDTO.builder()
                .id(orderItem.getId())
                .book(toBook(orderItem.getBook()))
                .build();
    }

    /**
     * Converts a list of {@link OrderItem} objects to a list of {@link OrderItemDTO}.
     *
     * @param orderItems The list of {@link OrderItem} objects to be converted.
     * @return A list of {@link OrderItemDTO} objects containing data from the source objects.
     */
    public List<OrderItemDTO> toDTO(List<OrderItem> orderItems) {

        return orderItems.stream()
                .map(OrderItemMapper::toDTO)
                .toList();
    }

    private OrderItemDTO.OrderItemBook toBook(Book source) {
        return OrderItemDTO.OrderItemBook.builder()
                .id(source.getId())
                .name(source.getName())
                .authorFullName(source.getAuthorFullName())
                .isbn(source.getIsbn())
                .price(source.getPrice())
                .build();
    }

}
