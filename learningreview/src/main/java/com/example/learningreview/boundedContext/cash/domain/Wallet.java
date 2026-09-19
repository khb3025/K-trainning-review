package com.example.learningreview.boundedContext.cash.domain;

import com.example.learningreview.global.jpa.entity.BaseManualIdAndTime;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "CASH_WALLET")
public class Wallet extends BaseManualIdAndTime {

    @OneToOne(fetch = FetchType.LAZY)
    private CashMember holder;

    public Wallet(CashMember holder) {
        super(
            holder.getId()
        );
        this.holder = holder;
    }
}
