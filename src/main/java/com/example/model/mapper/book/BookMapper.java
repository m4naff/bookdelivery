package com.example.model.mapper.book;

import com.example.demo.BookDTO;
import com.example.model.Book;
import com.example.payload.request.book.BookCreateRequest;
import com.example.payload.request.book.BookUpdateRequest;
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

    /**
     * Updates the {@link Book} entity given as a parameter using the
     * {@link BookUpdateRequest} DTO object given as a parameter. <br>
     * This method has no return, the update operation is performed through
     * the reference of the object.
     *
     * @param bookEntityToBeUpdate {@link Book} entity to be updated
     * @param request              {@link BookUpdateRequest} request DTO object containing update details
     */
    public static void mapForUpdating(Book bookEntityToBeUpdate, BookUpdateRequest request) {
        bookEntityToBeUpdate.setIsbn(request.getIsbn());
        bookEntityToBeUpdate.setName(request.getName());
        bookEntityToBeUpdate.setAuthorFullName(request.getAuthorFullName());
        bookEntityToBeUpdate.setStock(request.getStock());
        bookEntityToBeUpdate.setPrice(request.getPrice());
    }
}
