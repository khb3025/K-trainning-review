package com.example.learningreview.shared.member.event;

import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Getter
public class MemberJoinedEvent {
    private final MemberDto memberDto;
}
