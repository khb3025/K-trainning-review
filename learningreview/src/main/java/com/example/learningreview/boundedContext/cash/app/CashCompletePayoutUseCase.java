package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashLog;
import com.example.learningreview.boundedContext.cash.domain.Wallet;
import com.example.learningreview.boundedContext.cash.out.WalletRepository;
import com.example.learningreview.shared.payout.dto.PayoutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashCompletePayoutUseCase {

    private final CashSupport cashSupport;

    public void completePayout(PayoutDto payout) {
        Wallet payeeWallet = cashSupport.findWalletByHolderId(payout.getPayeeId()).get();
        Wallet holdingWallet = cashSupport.findHoldingWallet().get();

        payeeWallet.credit(
                payout.getAmount(),
                payout.isPayeeSystem() ? CashLog.EventType.정산수령__상품판매_수수료 : CashLog.EventType.정산수령__상품판매_대금,
                payout.getModelTypeCode(),
                payout.getId()
        );

        holdingWallet.debit(
                payout.getAmount(),
                payout.isPayeeSystem() ? CashLog.EventType.정산수령__상품판매_수수료 : CashLog.EventType.정산수령__상품판매_대금,
                payout.getModelTypeCode(),
                payout.getId()
        );

    }
}
