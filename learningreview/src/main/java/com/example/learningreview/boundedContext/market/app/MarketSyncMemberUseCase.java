package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.boundedContext.market.out.MarketMemberRepository;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import com.example.learningreview.shared.market.dto.MarketMemberDto;
import com.example.learningreview.shared.market.event.MarketMemberCreatedEvent;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketSyncMemberUseCase {

    private final MarketMemberRepository marketMemberRepository;
    private final EventPublisher eventPublisher;

    public MarketMember syncMember(MemberDto memberDto) {
        boolean isNew = marketMemberRepository.existsById(memberDto.getId());

        MarketMember marketMember = new MarketMember(
                memberDto.getId(),
                memberDto.getCreateDate(),
                memberDto.getModifyDate(),
                memberDto.getUsername(),
                memberDto.getNickname(),
                "",
                memberDto.getActivityScore()
        );

        if(isNew){
            eventPublisher.publish(
                new MarketMemberCreatedEvent(
                    new MarketMemberDto(marketMember)
                )
            );
        }
        return marketMemberRepository.save(marketMember);
    }
}
