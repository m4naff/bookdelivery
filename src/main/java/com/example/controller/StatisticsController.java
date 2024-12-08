package com.example.controller;

import com.example.dto.OrderDTO;
import com.example.dto.OrderReportDTO;
import com.example.model.mapper.statistics.OrderReportMapper;
import com.example.payload.request.book.PaginationRequest;
import com.example.payload.response.CustomPageResponse;
import com.example.payload.response.auth.CustomResponse;
import com.example.payload.response.order.OrderGetResponse;
import com.example.payload.response.statistics.OrderReportResponse;
import com.example.service.StatisticsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/statistics")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/{customerId}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN','ROLE_CUSTOMER')")
    public CustomResponse<CustomPageResponse<OrderReportResponse>> getOrderStatisticsByCustomerId(
            @PathVariable Long customerId,
            @RequestBody PaginationRequest paginationRequest
            ) {
        Page<OrderReportDTO> orderReportDTOs = statisticsService.
                getOrderStatisticsByCustomerId(customerId, paginationRequest);
        CustomPageResponse<OrderReportResponse> orderReportResponse = OrderReportMapper.toOrderReportResponseList(orderReportDTOs);
        return CustomResponse.ok(orderReportResponse);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public CustomResponse<CustomPageResponse<OrderReportResponse>> getAllOrderStatistics(
            @RequestBody PaginationRequest paginationRequest
    ) {
        Page<OrderReportDTO> orderReportDTOS = statisticsService.getAllOrderStatistics(paginationRequest);
        CustomPageResponse<OrderReportResponse> orderReportResponse = OrderReportMapper.toOrderReportResponseList(orderReportDTOS);
        return CustomResponse.ok(orderReportResponse);
    }

}
