package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.shared.member.dto.MemberDto;
import com.example.learningreview.shared.payout.dto.PayoutMemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayoutCreatePayoutUseCase {

    public void createPayout(PayoutMemberDto payee) {
        log.debug("createPayout.payee: {}", payee.getId());
    }
}
