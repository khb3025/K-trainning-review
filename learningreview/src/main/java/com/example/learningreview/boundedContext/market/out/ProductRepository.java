package com.example.learningreview.boundedContext.market.out;

import com.example.learningreview.boundedContext.market.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByName(String name);
}
