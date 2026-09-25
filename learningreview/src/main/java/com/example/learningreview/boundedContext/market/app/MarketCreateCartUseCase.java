package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.Cart;
import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.boundedContext.market.out.CartRepository;
import com.example.learningreview.boundedContext.market.out.MarketMemberRepository;
import com.example.learningreview.global.RsData.RsData;
import com.example.learningreview.shared.market.dto.MarketMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketCreateCartUseCase {

    private final CartRepository cartRepository;
    private final MarketMemberRepository marketMemberRepository;

    public RsData<Cart> createCart(MarketMemberDto buyer) {
        MarketMember _buyer = marketMemberRepository.getReferenceById(buyer.getId());
        Cart cart = new Cart(_buyer);
        cartRepository.save(cart);
        return new RsData<>("201-1","장바구니가 생성되었습니다.",cart);
    }
}
