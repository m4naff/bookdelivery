package com.example.service;

import com.example.payload.request.book.BookCreateRequest;

/**
 * This interface defines a service for managing books.
 */
public interface BookService {

    /**
     * Creates a new book based on the provided request.
     *
     * @param request The request containing book information.
     * @return A {@link BookDTO} representing the newly created book.
     */
    BookDTO createBook(BookCreateRequest request);

}
