package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.member.dto.MemberDto;
import com.example.learningreview.shared.payout.dto.PayoutMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayoutFacade {

    private final PayoutSyncMemberUseCase payoutSyncMemberUseCase;
    private final PayoutCreatePayoutUseCase payoutCreatePayoutUseCase;
    private final PayoutAddPayoutCandidateItemsUseCase payoutAddPayoutCandidateItemsUseCase;

    public void syncMember(MemberDto member) {
        payoutSyncMemberUseCase.syncMember(member);
    }

    public void createPayout(PayoutMemberDto member) {
        payoutCreatePayoutUseCase.createPayout(member);
    }

    public void addPayoutCandidateItems(OrderDto order) {
        payoutAddPayoutCandidateItemsUseCase.addPayoutCandidateItems(order);
    }
}
