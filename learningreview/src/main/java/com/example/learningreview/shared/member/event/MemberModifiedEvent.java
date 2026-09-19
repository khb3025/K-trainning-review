package com.example.learningreview.shared.member.event;

import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberModifiedEvent {
    private final MemberDto memberDto;
}
