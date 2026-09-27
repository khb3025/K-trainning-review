package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.boundedContext.payout.domain.Payout;
import com.example.learningreview.boundedContext.payout.domain.PayoutCandidateItem;
import com.example.learningreview.global.RsData.RsData;
import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.member.dto.MemberDto;
import com.example.learningreview.shared.payout.dto.PayoutMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayoutFacade {
    private final PayoutSupport payoutSupport;
    private final PayoutSyncMemberUseCase payoutSyncMemberUseCase;
    private final PayoutCreatePayoutUseCase payoutCreatePayoutUseCase;
    private final PayoutAddPayoutCandidateItemsUseCase payoutAddPayoutCandidateItemsUseCase;
    private final PayoutCollectPayoutItemsMoreUseCase payoutCollectPayoutItemsMoreUseCase;
    private final PayoutCompletePayoutsMoreUseCase payoutCompletePayoutsMoreUseCase;
    public void syncMember(MemberDto member) {
        payoutSyncMemberUseCase.syncMember(member);
    }

    public Payout createPayout(int payeeId) {
        return payoutCreatePayoutUseCase.createPayout(payeeId);
    }

    public void addPayoutCandidateItems(OrderDto order) {
        payoutAddPayoutCandidateItemsUseCase.addPayoutCandidateItems(order);
    }

    public RsData<Integer> collectPayoutItemsMore(int limit){
        return payoutCollectPayoutItemsMoreUseCase.collectPayoutItemsMore(limit);
    }

    public List<PayoutCandidateItem> findPayoutCandidateItems(){
        return payoutSupport.findPayoutCandidateItems();
    }

    @Transactional
    public RsData<Integer> completePayoutsMore(int limit) {
        return payoutCompletePayoutsMoreUseCase.completePayoutsMore(limit);
    }
}
