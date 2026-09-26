package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.boundedContext.payout.domain.PayoutCandidateItem;
import com.example.learningreview.boundedContext.payout.domain.PayoutEventType;
import com.example.learningreview.boundedContext.payout.domain.PayoutMember;
import com.example.learningreview.boundedContext.payout.out.PayoutCandidateItemRepository;
import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.market.dto.OrderItemDto;
import com.example.learningreview.shared.payout.out.MarketApiClient;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PayoutAddPayoutCandidateItemsUseCase {

    private final MarketApiClient marketApiClient;
    private final PayoutSupport payoutSupport;
    private final PayoutCandidateItemRepository payoutCandidateItemRepository;

    public void addPayoutCandidateItems(OrderDto order) {
        marketApiClient.getOrderItems(order.getId())
                .forEach(
                        orderItem -> makePayoutCandidateItems(order, orderItem)
                );
    }

    private void makePayoutCandidateItems(
            OrderDto order, OrderItemDto orderItem
    ){

        PayoutMember buyer = payoutSupport.findMemberById(order.getBuyerId()).get();
        PayoutMember seller = payoutSupport.findMemberById(orderItem.getSellerId()).get();
        PayoutMember system = payoutSupport.findSystemMember().get();

        makePayoutCandidateItem(
                PayoutEventType.정산__상품판매_수수료,
                orderItem.getModelTypeCode(),
                orderItem.getOrderId(),
                order.getPaymentDate(),
                buyer,
                system,
                orderItem.getPayoutFee()
        );

        makePayoutCandidateItem(
                PayoutEventType.정산__상품판매_대금,
                orderItem.getModelTypeCode(),
                orderItem.getOrderId(),
                order.getPaymentDate(),
                buyer,
                seller,
                orderItem.getSalePriceWithoutFee()
        );
    }
    private void makePayoutCandidateItem(
            PayoutEventType eventType,
            String modelTypeCode,
            int relId,
            LocalDateTime paymentDate,
            PayoutMember payer,
            PayoutMember payee,
            long amount
    ){
        PayoutCandidateItem payoutCandidateItem = new PayoutCandidateItem(
                eventType,
                modelTypeCode,
                relId,
                paymentDate,
                payer,
                payee,
                amount
        );
        payoutCandidateItemRepository.save(payoutCandidateItem);
    }


}
