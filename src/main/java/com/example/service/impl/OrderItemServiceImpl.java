package com.example.service.impl;

import com.example.dto.BookDTO;
import com.example.dto.OrderItemDTO;
import com.example.model.Book;
import com.example.model.OrderItem;
import com.example.model.mapper.book.BookMapper;
import com.example.model.mapper.order.OrderItemMapper;
import com.example.payload.request.book.BookUpdateStockRequest;
import com.example.payload.request.order.OrderItemRequest;
import com.example.service.BookService;
import com.example.service.OrderItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This class implements the {@link OrderItemService} interface.
 */
@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final BookService bookService;

    /**
     * Creates an OrderItem based on the information provided in the OrderItemRequest.
     * This method performs the following steps:
     * 1. Retrieves the BookDTO for the specified bookId.
     * 2. Converts the BookDTO to a Book entity.
     * 3. Checks if there is sufficient stock available for the requested amount,
     * throwing a {@link com.example.exception.book.NoAvailableStockException} if stock is insufficient.
     * 4. Constructs an OrderItem entity with the associated Book.
     * 5. Updates the stock of the Book entity in the database.
     * Important: Pessimistic Write lock is being applied on this step, to make sure that
     * the book data is not corrupted.
     * 6. Returns the OrderItemDTO representing the created OrderItem.
     *
     * @param orderDetailRequest The request containing information for creating an OrderItem,
     *                           including the bookId and the amount.
     * @return An OrderItemDTO representing the created OrderItem.
     * @throws com.example.exception.book.NoAvailableStockException If there is not enough stock available for the requested amount.
     *                                                                   Note: This method handles the creation of an OrderItem entity, ensuring that the associated
     *                                                                   Book has sufficient stock. If stock is insufficient, it throws a NoAvailableStockException.
     */
    @Override
    @Transactional
    public OrderItemDTO createOrderItem(OrderItemRequest orderDetailRequest) {

        final BookDTO bookDTO = bookService.getBookById(orderDetailRequest.getBookId());
        final Book book = BookMapper.toBook(bookDTO);

        bookService.isStockAvailable(bookDTO, orderDetailRequest.getAmount());

        final OrderItem orderItem = OrderItem.builder()
                .book(book)
                .build();

        BookUpdateStockRequest bookUpdateStockRequest = BookUpdateStockRequest.builder()
                .stock(bookDTO.getStock() - orderDetailRequest.getAmount())
                .build();

        bookService.updateBookStockById(bookDTO.getId(), bookUpdateStockRequest);

        return OrderItemMapper.toDTO(orderItem);

    }

}
