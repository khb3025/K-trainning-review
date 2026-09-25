package com.example.learningreview.shared.market.event;

import com.example.learningreview.shared.market.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashOrderPaymentSucceededEvent {
    private final OrderDto order;
    private final long pgPaymentAmount;

}
