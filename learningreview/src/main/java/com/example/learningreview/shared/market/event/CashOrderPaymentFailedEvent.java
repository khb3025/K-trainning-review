package com.example.learningreview.shared.market.event;

import com.example.learningreview.shared.market.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashOrderPaymentFailedEvent {
    private String resultType;
    private String msg;
    private OrderDto order;
    private long pgPaymentAmount;
    private long shortfallAmount;
}
