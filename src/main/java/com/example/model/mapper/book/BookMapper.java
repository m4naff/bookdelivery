package com.example.model.mapper.book;

import com.example.demo.BookDTO;
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


    /**
     * Converts a {@link Book} entity to a {@link BookDTO}.
     *
     * @param book The {@link Book} entity to be converted.
     * @return A {@link BookDTO} containing data from the source entity.
     */
    public static BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .isbn(book.getIsbn())
                .name(book.getName())
                .authorFullName(book.getAuthorFullName())
                .price(book.getPrice())
                .stock(book.getStock())
                .build();
    }
}
