package com.example.learningreview.boundedContext.cash.domain;

import com.example.learningreview.global.jpa.entity.BaseEntity;
import com.example.learningreview.global.jpa.entity.BaseManualIdAndTime;
import com.example.learningreview.shared.cash.dto.WalletDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "CASH_WALLET")
public class Wallet extends BaseManualIdAndTime {

    @OneToOne(fetch = FetchType.LAZY)
    private CashMember holder;

    private long balance;

    @OneToMany(mappedBy = "wallet",
               cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
               orphanRemoval = true)
    private List<CashLog> cashLogs = new ArrayList<>();

    public Wallet(CashMember holder) {
        super(
            holder.getId()
        );
        this.holder = holder;
    }

    public boolean hasBalance() {
        return balance > 0;
    }

    public void credit(
            long amount,
            CashLog.EventType eventType,
            String relTypeCode,
            int relId
    ){
        this.balance += amount;
        addCashLog(amount, eventType, relTypeCode, relId);
    }

    public void credit(
        long amount,
        CashLog.EventType eventType,
        BaseEntity rel
    ) {
        credit(amount, eventType, rel.getModelTypeCode(), rel.getId());
    }

    public void credit(long amount, CashLog.EventType eventType) {
        credit(amount, eventType, holder);
    }

    public void debit(
            long amount,
            CashLog.EventType eventType,
            String relTypeCode,
            int relId
    ){
        this.balance -= amount;
        addCashLog(amount, eventType, relTypeCode, relId);
    }

    public void debit(
            long amount,
            CashLog.EventType eventType,
            BaseEntity rel
    ) {
        debit(amount, eventType, rel.getModelTypeCode(), rel.getId());
    }

    public void debit(long amount, CashLog.EventType eventType) {
        debit(amount, eventType, holder);
    }

    private CashLog addCashLog(
            long amount,
            CashLog.EventType eventType,
            String relTypeCode,
            int relId
    ) {
        CashLog cashLog = new CashLog(
                eventType,
                relTypeCode,
                relId,
                holder,
                this,
                amount,
                balance
        );
        cashLogs.add(cashLog);
        return cashLog;
    }

    public WalletDto toDto(){
        return new WalletDto(
                getId(),
                getCreateDate(),
                getModifyDate(),
                getHolder().getId(),
                getHolder().getUsername(),
                getBalance()
        );
    }
}
