package com.example.learningreview.shared.cash.dto;

import com.example.learningreview.boundedContext.cash.domain.Wallet;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class WalletDto {

    private final int id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final int holderId;
    private final String holderName;
    private final long balance;

    public WalletDto(
            Wallet wallet
    ){
        this(
                wallet.getId(),
                wallet.getCreateDate(),
                wallet.getModifyDate(),
                wallet.getHolder().getId(),
                wallet.getHolder().getUsername(),
                wallet.getBalance()
        );
    }
}
