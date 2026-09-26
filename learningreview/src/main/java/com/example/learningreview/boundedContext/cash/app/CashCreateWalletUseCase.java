package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashMember;
import com.example.learningreview.boundedContext.cash.domain.Wallet;
import com.example.learningreview.boundedContext.cash.out.CashMemberRepository;
import com.example.learningreview.boundedContext.cash.out.WalletRepository;
import com.example.learningreview.shared.cash.dto.CashMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashCreateWalletUseCase {

    private final WalletRepository walletRepository;
    private final CashMemberRepository cashMemberRepository;

    public Wallet createWallet(CashMemberDto member){
        CashMember _member = cashMemberRepository.getReferenceById(member.getId());
        Wallet wallet = new Wallet(_member);
        return walletRepository.save(wallet);
    }

}
