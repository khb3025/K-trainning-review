package com.example.learningreview.boundedContext.cash.out;

import com.example.learningreview.boundedContext.cash.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
