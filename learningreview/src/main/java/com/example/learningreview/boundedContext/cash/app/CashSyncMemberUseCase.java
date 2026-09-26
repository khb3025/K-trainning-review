package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashMember;
import com.example.learningreview.boundedContext.cash.out.CashMemberRepository;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import com.example.learningreview.shared.cash.dto.CashMemberDto;
import com.example.learningreview.shared.cash.event.CashMemberCreatedEvent;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CashSyncMemberUseCase {

    private final CashMemberRepository cashMemberRepository;
    private final EventPublisher eventPublisher;
    public CashMember syncMember(MemberDto member) {
        boolean isNew = !cashMemberRepository.existsById(member.getId());

        CashMember cashMember = new CashMember(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                member.getNickname(),
                "",
                member.getActivityScore()
        );

        if (isNew) {
            eventPublisher.publish(
                    new CashMemberCreatedEvent(
                            cashMember.toDto()
                    )
            );
        }
        return cashMemberRepository.save(cashMember);
    }
}
