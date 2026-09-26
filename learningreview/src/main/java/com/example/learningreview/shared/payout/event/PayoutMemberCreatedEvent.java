package com.example.learningreview.shared.payout.event;

import com.example.learningreview.shared.payout.dto.PayoutMemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PayoutMemberCreatedEvent {
    private PayoutMemberDto member;
}
