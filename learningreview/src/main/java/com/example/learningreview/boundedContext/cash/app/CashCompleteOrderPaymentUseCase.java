package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashLog;
import com.example.learningreview.boundedContext.cash.domain.CashPolicy;
import com.example.learningreview.boundedContext.cash.domain.Wallet;
import com.example.learningreview.boundedContext.cash.out.WalletRepository;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.market.event.CashOrderPaymentFailedEvent;
import com.example.learningreview.shared.market.event.CashOrderPaymentSucceededEvent;
import com.example.learningreview.shared.market.event.MarketOrderPaymentRequestEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashCompleteOrderPaymentUseCase {

    private final CashSupport cashSupport;
    private final EventPublisher eventPublisher;

    public void handle(MarketOrderPaymentRequestEvent event){

        Wallet buyer = cashSupport.findWalletByHolderId(event.getOrder().getBuyerId()).get();
        Wallet holding = cashSupport.findHoldingWallet().get();

        // PG 충전 금액
        if(event.getPgPaymentAmount() > 0){
            buyer.credit(event.getPgPaymentAmount(),
                         CashLog.EventType.충전__PG결제_토스페이먼츠,
                    "Order",
                        event.getOrder().getId());
        }

        boolean canPay = buyer.getBalance() >= event.getOrder().getSalePrice();

        if(canPay){
            // buyer 차감 && holding 증가
            buyer.debit(
                    event.getOrder().getSalePrice(),
                    CashLog.EventType.사용__주문결제,
                    "Order",
                    event.getOrder().getId()
            );
            holding.credit(
                    event.getOrder().getSalePrice(),
                    CashLog.EventType.임시보관__주문결제,
                    "Order",
                    event.getOrder().getId()
            );

            eventPublisher.publish(
                    new CashOrderPaymentSucceededEvent(
                            event.getOrder(),
                            event.getPgPaymentAmount()
                    )
            );

        }else{
            eventPublisher.publish(
                    new CashOrderPaymentFailedEvent(
                            "400-1",
                            "충전은 완료했지만 %번 주문을 결제완료처리를 하기에는 예치금이 부족합니다.".formatted(event.getOrder().getId()),
                            event.getOrder(),
                            event.getPgPaymentAmount(),
                            event.getOrder().getSalePrice() - buyer.getBalance()
                    )
            );
        }
    }
}
