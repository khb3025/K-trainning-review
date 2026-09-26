package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.boundedContext.payout.domain.Payout;
import com.example.learningreview.boundedContext.payout.domain.PayoutMember;
import com.example.learningreview.boundedContext.payout.out.PayoutMemberRepository;
import com.example.learningreview.boundedContext.payout.out.PayoutRepository;
import com.example.learningreview.shared.member.dto.MemberDto;
import com.example.learningreview.shared.payout.dto.PayoutMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayoutCreatePayoutUseCase {

    private final PayoutRepository payoutRepository;
    private final PayoutMemberRepository payoutMemberRepository;

    public Payout createPayout(PayoutMemberDto payee) {
        PayoutMember _payee = payoutMemberRepository.getReferenceById(payee.getId());
        Payout payout = new Payout(_payee);
        return payoutRepository.save(payout);
    }
}
