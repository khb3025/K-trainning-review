package com.example.learningreview.boundedContext.market.out;

import com.example.learningreview.boundedContext.market.domain.MarketMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketMemberRepository extends JpaRepository<MarketMember,Integer> {
    Optional<MarketMember> findByUsername(String username);
}
