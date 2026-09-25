package com.example.learningreview.boundedContext.market.out;

import com.example.learningreview.boundedContext.market.domain.Cart;
import com.example.learningreview.boundedContext.market.domain.MarketMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    Optional<Cart> findByBuyer(MarketMember buyer);
}
