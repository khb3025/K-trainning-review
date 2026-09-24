package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.boundedContext.market.out.MarketMemberRepository;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketSyncMemberUseCase {

    private MarketMemberRepository marketMemberRepository;

    public MarketMember syncMember(MemberDto memberDto) {
        MarketMember marketMember = new MarketMember(
                memberDto.getId(),
                memberDto.getCreateDate(),
                memberDto.getModifyDate(),
                memberDto.getUsername(),
                memberDto.getNickname(),
                "",
                memberDto.getActivityScore()
        );
        return marketMemberRepository.save(marketMember);
    }


}
