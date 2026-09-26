package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.shared.market.dto.OrderDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayoutAddPayoutCandidateItemsUseCase {

    public void addPayoutCandidateItems(OrderDto order) {
        log.debug("addPayoutCandidateItems.order: {}", order.getId());

    }
}
