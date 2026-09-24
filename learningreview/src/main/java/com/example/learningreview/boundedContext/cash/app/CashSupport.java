package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashMember;
import com.example.learningreview.boundedContext.cash.domain.Wallet;
import com.example.learningreview.boundedContext.cash.out.CashMemberRepository;
import com.example.learningreview.boundedContext.cash.out.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CashSupport {

    private final WalletRepository walletRepository;
    private final CashMemberRepository cashMemberRepository;

    // CashMemberRepository
    public Optional<CashMember> findMemberByUsername(String username) {
        return cashMemberRepository.findByUsername(username);
    }

    // WalletRepository
    public Optional<Wallet> findWalletByHolder(CashMember cashMember) {
        return walletRepository.findByHolder(cashMember);
    }

}
