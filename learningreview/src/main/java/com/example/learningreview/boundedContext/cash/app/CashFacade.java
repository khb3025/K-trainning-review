package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashMember;
import com.example.learningreview.boundedContext.cash.domain.Wallet;
import com.example.learningreview.boundedContext.cash.out.CashMemberRepository;
import com.example.learningreview.boundedContext.cash.out.WalletRepository;
import com.example.learningreview.shared.market.event.MarketOrderPaymentRequestEvent;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CashFacade {
    private final CashSyncMemberUseCase cashSyncMemberUseCase;
    private final CashSupport cashSupport;
    private final CashCreateWalletUseCase cashCreateWalletUseCase;
    private final CashCompleteOrderPaymentUseCase cashCompleteOrderPaymentUseCase;


    public CashMember syncMember(MemberDto memberDto){
        return cashSyncMemberUseCase.syncMember(memberDto);
    }

    @Transactional
    public Wallet createWallet(CashMember cashMember){
        return cashCreateWalletUseCase.createWallet(cashMember);
    }

    public Optional<CashMember> findMemberByUsername(String username) {
        return cashSupport.findMemberByUsername(username);
    }

    public Optional<Wallet> findWalletByHolder(CashMember cashMember) {
        return cashSupport.findWalletByHolder(cashMember);
    }

    public void handle(MarketOrderPaymentRequestEvent event) {
        cashCompleteOrderPaymentUseCase.handle(event);
    }
}
