package com.example.learningreview.boundedContext.cash.in;

import com.example.learningreview.boundedContext.cash.app.CashFacade;
import com.example.learningreview.boundedContext.cash.domain.CashMember;
import com.example.learningreview.shared.cash.event.CashMemberCreatedEvent;
import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.market.event.MarketOrderPaymentRequestEvent;
import com.example.learningreview.shared.member.event.MemberJoinedEvent;
import com.example.learningreview.shared.member.event.MemberModifiedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class CashEventListener {

    private final CashFacade cashFacade;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(MemberJoinedEvent event){
        CashMember cashMember = cashFacade.syncMember(event.getMemberDto());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(MemberModifiedEvent event){
        cashFacade.syncMember(event.getMemberDto());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(CashMemberCreatedEvent event){

        cashFacade.createWallet(event.getCashMemberDto());
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handle(MarketOrderPaymentRequestEvent event){
        OrderDto order = event.getOrder();
        long pgPaymentAmount = event.getPgPaymentAmount();
        cashFacade.completeOrderPayment(order, pgPaymentAmount);
    }


}
