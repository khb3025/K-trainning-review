package com.example.learningreview.boundedContext.payout.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Entity
@Table(name="PAYOUT_PAYOUT_ITEM")
public class PayoutItem extends BaseIdAndTime {
    @ManyToOne(fetch = LAZY)
    private Payout payout;
    @Enumerated(EnumType.STRING)
    private PayoutEventType eventType;
    private LocalDateTime paymentDate;
    @ManyToOne(fetch = LAZY)
    private PayoutMember payer;
    @ManyToOne(fetch = LAZY)
    private PayoutMember payee;
    private long amount;

    public PayoutItem(
            Payout payout,
            PayoutEventType eventType,
            LocalDateTime paymentDate,
            PayoutMember payer,
            PayoutMember payee,
            long amount
    ){
        this.payout = payout;
        this.eventType = eventType;
        this.paymentDate = paymentDate;
        this.payer = payer;
        this.payee = payee;
        this.amount = amount;
    }
}
