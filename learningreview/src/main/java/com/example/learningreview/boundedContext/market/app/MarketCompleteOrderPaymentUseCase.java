package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.Order;
import com.example.learningreview.boundedContext.market.out.OrderRepository;
import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.market.event.CashOrderPaymentSucceededEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketCompleteOrderPaymentUseCase {

    private final OrderRepository orderRepository;

    public void completeOrderPayment(OrderDto order) {
        Order _order = orderRepository.findById(order.getId()).get();
        _order.completePayment();
    }
}
