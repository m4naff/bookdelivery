package com.example.service;

import com.example.demo.BookDTO;
import com.example.payload.request.book.BookCreateRequest;
import com.example.payload.request.book.BookUpdateStockRequest;

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

    /**
     * Retrieves a book by its unique identifier.
     *
     * @param bookId The unique identifier of the book.
     * @return A {@link BookDTO} representing the requested book.
     */
    BookDTO getBookById(String bookId);

    /**
     * Updates the stock quantity of a book by its unique identifier.
     *
     * @param bookId The unique identifier of the book.
     * @param request The request containing the updated stock information.
     * @return A {@link BookDTO} representing the book after the stock update.
     */
    BookDTO updateBookStockById(String bookId, BookUpdateStockRequest request);

}
