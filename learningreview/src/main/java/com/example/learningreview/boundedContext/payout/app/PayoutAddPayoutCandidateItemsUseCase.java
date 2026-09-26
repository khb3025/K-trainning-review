package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.market.dto.OrderItemDto;
import com.example.learningreview.shared.payout.out.MarketApiClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayoutAddPayoutCandidateItemsUseCase {

    private final MarketApiClient marketApiClient;

    public void addPayoutCandidateItems(OrderDto order) {
        List<OrderItemDto> orderItems = marketApiClient
                .getOrderItems(order.getId());

        orderItems.forEach(orderItem -> {
            log.info("orderItem: {}", orderItem);
        });
    }
}
