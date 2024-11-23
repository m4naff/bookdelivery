package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Data Transfer Object (DTO) representing order report information.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderReportDTO {

    private static final Map<Integer, String> MONTH_NAMES = new HashMap<>();

    static {
        MONTH_NAMES.put(1, "January");
        MONTH_NAMES.put(2, "February");
        MONTH_NAMES.put(3, "March");
        MONTH_NAMES.put(4, "April");
        MONTH_NAMES.put(5, "May");
        MONTH_NAMES.put(6, "June");
        MONTH_NAMES.put(7, "July");
        MONTH_NAMES.put(8, "August");
        MONTH_NAMES.put(9, "September");
        MONTH_NAMES.put(10, "October");
        MONTH_NAMES.put(11, "November");
        MONTH_NAMES.put(12, "December");
    }

    private String month;
    private Integer year;
    private Long totalOrderCount;
    private Long totalBookCount;
    private BigDecimal totalPrice;

    public OrderReportDTO(Integer month, Integer year, Long totalOrderCount, Long totalBookCount, BigDecimal totalPrice) {
        this.month = MONTH_NAMES.get(month);
        this.year = year;
        this.totalOrderCount = totalOrderCount;
        this.totalBookCount = totalBookCount;
        this.totalPrice = totalPrice;
    }
}
