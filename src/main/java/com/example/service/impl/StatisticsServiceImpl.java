package com.example.service.impl;

import com.example.dto.OrderReportDTO;
import com.example.model.enums.Role;
import com.example.payload.request.book.PaginationRequest;
import com.example.repository.OrderRepository;
import com.example.security.CustomUserDetails;
import com.example.service.StatisticsService;
import com.example.util.Identify;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

/**
 * Implementation of the {@link StatisticsService} interface for retrieving order statistics.
 */
@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final OrderRepository orderRepository;

    private final Identify identify;

    /**
     * Retrieves order statistics for a specific customer.
     *
     * @param customerId        The unique identifier of the customer.
     * @param paginationRequest The request containing pagination information.
     * @return A {@link Page} of {@link OrderReportDTO} objects representing order statistics for the customer.
     */
    @Override
    public Page<OrderReportDTO> getOrderStatisticsByCustomerId(Long customerId, PaginationRequest paginationRequest) {
        final CustomUserDetails userDetails = identify.getCustomUserDetails();
        final Role userRole = userDetails.getUser().getRole();

        if ((userRole.equals(Role.ROLE_CUSTOMER)) && userDetails.getId().equals(customerId)
            || userRole.equals(Role.ROLE_ADMIN)) {
            return orderRepository.findOrderStatisticsByCustomerId(customerId, paginationRequest.toPageable());
        }
        throw new AccessDeniedException("You cannot access order statistics");
    }

    @Override
    public Page<OrderReportDTO> getAllOrderStatistics(PaginationRequest paginationRequest) {
        return null;
    }
}
