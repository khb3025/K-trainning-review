package com.example.learningreview.shared.market.event;

import com.example.learningreview.shared.market.dto.MarketMemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MarketMemberCreatedEvent {
    private final MarketMemberDto member;
}
