package com.example.learningreview.shared.payout.dto;

import com.example.learningreview.standard.HasModelTypeCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class PayoutDto implements HasModelTypeCode {
    private final int id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final int payeeId;
    private final String payeeName;
    private final LocalDateTime payoutDate;
    private final long amount;
    private final boolean isPayeeSystem;

    @Override
    public String getModelTypeCode() {
        return "Payout";
    }
}
