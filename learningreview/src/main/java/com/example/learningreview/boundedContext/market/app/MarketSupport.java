package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.boundedContext.market.out.MarketMemberRepository;
import com.example.learningreview.boundedContext.market.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketSupport {
    private final MarketMemberRepository marketMemberRepository;
    private final ProductRepository productRepository;

    public long countProducts(){
        return productRepository.count();
    }

    public Optional<MarketMember> findMemberByUsername(String username) {
        return marketMemberRepository.findByUsername(username);
    }

}
