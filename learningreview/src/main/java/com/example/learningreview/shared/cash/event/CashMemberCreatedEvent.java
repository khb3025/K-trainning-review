package com.example.learningreview.shared.cash.event;

import com.example.learningreview.shared.cash.dto.CashMemberDto;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CashMemberCreatedEvent {
    private final CashMemberDto cashMemberDto;
}
