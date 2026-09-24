package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.boundedContext.market.domain.Product;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketFacade {

    private final MarketSyncMemberUseCase marketSyncMemberUseCase;
    private final MarketSupport marketSupport;
    private final MarketCreateProductUseCase marketCreateProductUseCase;

    @Transactional
    public MarketMember syncMember(MemberDto memberDto) {
        return marketSyncMemberUseCase.syncMember(memberDto);
    }

    @Transactional
    public Product createProduct(
            MarketMember seller,
            String sourceTypeCode,
            int sourceId,
            String name,
            String description,
            long price,
            long salePrice
    ){

        return marketCreateProductUseCase.createProduct(
                seller,
                sourceTypeCode,
                sourceId,
                name,
                description,
                price,
                salePrice
        );

    }

    public Optional<MarketMember> findMemberByUsername(String username){
        return marketSupport.findMemberByUsername(username);
    }
}
