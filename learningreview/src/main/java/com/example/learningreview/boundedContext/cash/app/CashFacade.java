package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashMember;
import com.example.learningreview.boundedContext.cash.domain.Wallet;
import com.example.learningreview.boundedContext.cash.out.CashMemberRepository;
import com.example.learningreview.boundedContext.cash.out.WalletRepository;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CashFacade {
    private final CashUseCase cashUseCase;
    private final CashMemberRepository cashMemberRepository;
    private final WalletRepository walletRepository;

    @Transactional
    public CashMember syncMember(MemberDto memberDto) {
        CashMember cashMember = new CashMember(
            memberDto.getId(),
            memberDto.getCreateDate(),
            memberDto.getModifyDate(),
            memberDto.getUsername(),
            memberDto.getNickname(),
            "",
            memberDto.getActivityScore()
        );
        return cashMemberRepository.save(cashMember);
    }

    @Transactional
    public Wallet createWallet(CashMember cashMember){
        Wallet wallet = new Wallet(cashMember);
        return walletRepository.save(wallet);
    }
}
