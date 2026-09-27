package com.example.learningreview.shared.payout.event;

import com.example.learningreview.shared.payout.dto.PayoutDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PayoutCompletedEvent {
    private final PayoutDto payout;
}
