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

    public void completeOrderPayment(
            OrderDto order,
            long pgPaymentAmount
    ){
        Wallet buyer = cashSupport.findWalletByHolderId(order.getBuyerId()).get();
        Wallet holding = cashSupport.findHoldingWallet().get();

        // PG 충전 금액
        if(pgPaymentAmount > 0){
            buyer.credit(pgPaymentAmount,
                         CashLog.EventType.충전__PG결제_토스페이먼츠,
                    "Order",
                        order.getId());
        }

        boolean canPay = buyer.getBalance() >= order.getSalePrice();

        if(canPay){
            // buyer 차감 && holding 증가
            buyer.debit(
                    order.getSalePrice(),
                    CashLog.EventType.사용__주문결제,
                    "Order",
                    order.getId()
            );
            holding.credit(
                    order.getSalePrice(),
                    CashLog.EventType.임시보관__주문결제,
                    "Order",
                    order.getId()
            );

            eventPublisher.publish(
                    new CashOrderPaymentSucceededEvent(
                            order,
                            pgPaymentAmount
                    )
            );

        }else{
            eventPublisher.publish(
                    new CashOrderPaymentFailedEvent(
                            "400-1",
                            "충전은 완료했지만 %번 주문을 결제완료처리를 하기에는 예치금이 부족합니다.".formatted(order.getId()),
                            order,
                            pgPaymentAmount,
                            order.getSalePrice() - buyer.getBalance()
                    )
            );
        }
    }
}
