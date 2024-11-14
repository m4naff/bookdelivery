package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Table(name = "books")
public class Book extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "name")
    private String name;

    @Column(name = "author_full_name")
    private String authorFullName;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "price")
    private BigDecimal price;

    @OneToMany(mappedBy = "book")
    private List<OrderItem> orderItems;
}
