package com.example.payload.request.book;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Represents a request object for pagination settings.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaginationRequest {

    @Min(0)
    private int page = 0;

    @Min(1)
    @Max(50)
    private int size = 10;

    /**
     * Converts the fields of this instance to {@link Pageable}
     *
     * @return Pageable
     */
    public Pageable toPageable() {
        return PageRequest.of(page, size);
    }

}
