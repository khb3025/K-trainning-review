package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.Cart;
import com.example.learningreview.boundedContext.market.domain.Order;
import com.example.learningreview.boundedContext.market.out.OrderRepository;
import com.example.learningreview.global.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MarketCreateOrderUseCase {
    private final OrderRepository orderRepository;

    public RsData<Order> createOrder(Cart cart) {
        Order order = new Order(cart);
        orderRepository.save(order);
        cart.clearItems();
        return new RsData("200-1", "%d주문이 생성되었습니다.".formatted(order.getId()), order);
    }
}
