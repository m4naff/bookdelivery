package com.example.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Data Transfer Object (DTO) representing book information.
 */
@Getter
@Setter
@EqualsAndHashCode
public class BookDTO {

    private String id;
    private String isbn;
    private String name;
    private String authorFullName;
    private BigDecimal price;
    private Integer stock;

}
