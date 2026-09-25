package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.Cart;
import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.boundedContext.market.domain.Order;
import com.example.learningreview.boundedContext.market.domain.Product;
import com.example.learningreview.boundedContext.market.out.CartRepository;
import com.example.learningreview.boundedContext.market.out.MarketMemberRepository;
import com.example.learningreview.boundedContext.market.out.OrderRepository;
import com.example.learningreview.boundedContext.market.out.ProductRepository;
import com.example.learningreview.global.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketSupport {
    private final MarketMemberRepository marketMemberRepository;
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    public long countProducts(){
        return productRepository.count();
    }

    public Optional<MarketMember> findMemberByUsername(String username) {
        return marketMemberRepository.findByUsername(username);
    }

    public Optional<Cart> findCartByBuyer(MarketMember buyer) {
        return cartRepository.findByBuyer(buyer);
    }

    public Optional<Product> findProductById(int id) {
        return productRepository.findById(id);
    }

    public long countOrders() {
        return orderRepository.count();
    }

    public Optional<Order> findOrderById(int id) {
        return orderRepository.findById(id);
    }
}
