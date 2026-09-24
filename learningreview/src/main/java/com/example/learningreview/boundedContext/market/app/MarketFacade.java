package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MarketFacade {

    private MarketSyncMemberUseCase marketSyncMemberUseCase;

    @Transactional
    public MarketMember syncMember(MemberDto memberDto) {
        return marketSyncMemberUseCase.syncMember(memberDto);
    }
}
