package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.Order;
import com.example.learningreview.boundedContext.market.out.OrderRepository;
import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.market.event.CashOrderPaymentFailedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketCancelOrderRequestPaymentUseCase {

    private final OrderRepository orderRepository;

    public void cancelOrderRequestPayment(OrderDto order) {
        Order _order = orderRepository.findById(order.getId()).get();
        _order.cancelPayment();
    }
}
