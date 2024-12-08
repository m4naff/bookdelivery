package com.example.payload.response.statistics;

import lombok.*;

import java.math.BigDecimal;

/**
 * Represents a response object for generating order reports, containing report data.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderReportResponse {

    private String month;
    private Integer year;
    private Long totalOrderCount;
    private Long totalBookCount;
    private BigDecimal totalPrice;

}
