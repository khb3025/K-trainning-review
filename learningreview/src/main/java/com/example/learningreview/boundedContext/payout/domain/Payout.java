package com.example.learningreview.boundedContext.payout.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@Table(name="PAYOUT_PAYOUT")
public class Payout extends BaseIdAndTime {
    @ManyToOne(fetch = LAZY)
    private PayoutMember payee;
    private LocalDateTime payoutDate;
    long amount;
    @OneToMany(
            mappedBy = "payout",
            cascade = {jakarta.persistence.CascadeType.REMOVE, jakarta.persistence.CascadeType.PERSIST},
            orphanRemoval = true
    )
    private List<PayoutItem> items = new ArrayList<>();

    public Payout(PayoutMember payee){
        this.payee = payee;
    }

    public PayoutItem addItem(
        PayoutEventType eventType,
        String relTypeCode,
        int relId,
        LocalDateTime payDate,
        PayoutMember payer,
        PayoutMember payee,
        long amount
    ){
        PayoutItem payoutItem  = new PayoutItem(
                this,
                eventType,
                payDate,
                payer,
                payee,
                amount
        );
        this.items.add(payoutItem);
        this.amount += amount;
        return payoutItem;
    }
}
