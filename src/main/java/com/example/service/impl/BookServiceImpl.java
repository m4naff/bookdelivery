package com.example.service.impl;

import com.example.demo.BookDTO;
import com.example.exception.book.BookNotFoundException;
import com.example.model.Book;
import com.example.model.mapper.book.BookMapper;
import com.example.payload.request.book.BookCreateRequest;
import com.example.payload.request.book.BookUpdateRequest;
import com.example.payload.request.book.BookUpdateStockRequest;
import com.example.payload.request.book.PaginationRequest;
import com.example.repository.BookRepository;
import com.example.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link BookService} interface for creating and managing books.
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /**
     * Creates a new book based on the provided request.
     *
     * @param request The request containing book information.
     * @return A {@link BookDTO} representing the newly created book.
     */
    @Override
    public BookDTO createBook(BookCreateRequest request) {
        final Book bookEntityToBeSaved = BookMapper.mapForSaving(request);

        return BookMapper.toDTO(bookRepository.save(bookEntityToBeSaved));
    }

    /**
     * Retrieves a book by its unique identifier.
     *
     * @param bookId The unique identifier of the book.
     * @return A {@link BookDTO} representing the requested book.
     */
    @Override
    public BookDTO getBookById(String bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(
                        () -> new BookNotFoundException(bookId)
                );
    }

    @Override
    public BookDTO updateBookStockById(String bookId, BookUpdateStockRequest request) {
        return null;
    }

    @Override
    public Page<BookDTO> getAllBooks(PaginationRequest paginationRequest) {
        return null;
    }

    @Override
    public BookDTO updateBookById(String bookId, BookUpdateRequest request) {
        return null;
    }

    @Override
    public boolean isStockAvailable(BookDTO bookDTO, int amount) {
        return false;
    }
}
