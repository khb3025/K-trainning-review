package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashMember;
import com.example.learningreview.boundedContext.cash.domain.Wallet;
import com.example.learningreview.boundedContext.cash.out.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashCreateWalletUseCase {

    private final WalletRepository walletRepository;

    public Wallet createWallet(CashMember cashMember){
        Wallet wallet = new Wallet(cashMember);
        return walletRepository.save(wallet);
    }

}
