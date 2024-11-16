package com.example.model.mapper.book;

import com.example.model.Book;
import com.example.payload.request.book.BookCreateRequest;
import lombok.experimental.UtilityClass;

/**
 * Utility class for mapping book-related entities.
 */
@UtilityClass
public class BookMapper {

    /**
     * Maps a {@link BookCreateRequest} to a {@link Book} entity for saving.
     *
     * @param request The {@link BookCreateRequest} to be mapped.
     * @return A new {@link Book} entity populated with data from the request.
     */
    public static Book mapForSaving(BookCreateRequest request) {
        return Book.builder()
                .isbn(request.getIsbn())
                .name(request.getName())
                .authorFullName(request.getAuthorFullName())
                .stock(request.getStock())
                .price(request.getPrice())
                .build();
    }



}
