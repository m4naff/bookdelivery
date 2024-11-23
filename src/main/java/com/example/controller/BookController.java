package com.example.controller;

import com.example.dto.BookDTO;
import com.example.model.mapper.book.BookMapper;
import com.example.payload.request.book.BookCreateRequest;
import com.example.payload.response.auth.CustomResponse;
import com.example.payload.response.book.BookCreatedResponse;
import com.example.service.BookService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class BookController {

    private final BookService bookService;

    /**
     * Creates a new Book entity.
     *
     * @param request The request body containing information for creating the Book.
     * @return Response containing information about the created Book.
     */
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponse<BookCreatedResponse> createBook(
            @RequestBody @Valid final BookCreateRequest request
            ){
        final BookDTO createdBookEntity = bookService.createBook(request);
        final BookCreatedResponse response = BookMapper.toCreatedResponse(createdBookEntity);

        return CustomResponse.created(response);
    }

}
