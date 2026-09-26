package com.example.learningreview.shared.market.event;

import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.standard.ResultType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashOrderPaymentFailedEvent implements ResultType {
    private String resultCode;
    private String msg;
    private OrderDto order;
    private long pgPaymentAmount;
    private long shortfallAmount;
}
