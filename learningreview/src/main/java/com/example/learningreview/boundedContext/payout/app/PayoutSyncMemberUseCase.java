package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.boundedContext.payout.domain.PayoutMember;
import com.example.learningreview.boundedContext.payout.out.PayoutMemberRepository;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import com.example.learningreview.shared.member.dto.MemberDto;
import com.example.learningreview.shared.payout.event.PayoutMemberCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayoutSyncMemberUseCase {

    private final PayoutMemberRepository payoutMemberRepository;
    private final EventPublisher eventPublisher;

    public void syncMember(MemberDto member){
        boolean isNew = payoutMemberRepository.existsById(member.getId());

        PayoutMember payoutMember = new PayoutMember(
                member.getId(),
                member.getCreateDate(),
                member.getModifyDate(),
                member.getUsername(),
                member.getNickname(),
                "",
                member.getActivityScore()
        );
        payoutMemberRepository.save(payoutMember);

        if(isNew){
            eventPublisher.publish(new PayoutMemberCreatedEvent(payoutMember.toDto()));
        }
    }
}
