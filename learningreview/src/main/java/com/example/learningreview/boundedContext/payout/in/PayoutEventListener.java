package com.example.learningreview.boundedContext.payout.in;

import com.example.learningreview.boundedContext.payout.app.PayoutFacade;
import com.example.learningreview.shared.market.event.MarketOrderPaymentCompletedEvent;
import com.example.learningreview.shared.member.event.MemberJoinedEvent;
import com.example.learningreview.shared.member.event.MemberModifiedEvent;
import com.example.learningreview.shared.payout.event.PayoutMemberCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class PayoutEventListener {

    private final PayoutFacade payoutFacade;

    @TransactionalEventListener( phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(MemberJoinedEvent event){
        payoutFacade.syncMember(event.getMemberDto());
    }

    @TransactionalEventListener( phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(MemberModifiedEvent event){
        payoutFacade.syncMember(event.getMemberDto());
    }

    @TransactionalEventListener( phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(PayoutMemberCreatedEvent event){
        payoutFacade.createPayout(event.getMember());
    }

    @TransactionalEventListener( phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(MarketOrderPaymentCompletedEvent event){
        payoutFacade.addPayoutCandidateItems(event.getOrder());
    }


}
