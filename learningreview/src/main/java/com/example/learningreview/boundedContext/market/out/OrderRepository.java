package com.example.learningreview.boundedContext.market.out;

import com.example.learningreview.boundedContext.market.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
