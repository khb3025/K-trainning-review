package com.example.learningreview.boundedContext.cash.app;

import com.example.learningreview.boundedContext.cash.domain.CashMember;
import com.example.learningreview.boundedContext.cash.out.CashMemberRepository;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CashFacade {
    private final CashUseCase cashUseCase;
    private final CashMemberRepository cashMemberRepository;

    @Transactional
    public void syncMember(MemberDto memberDto) {
        CashMember cashMember = new CashMember(
            memberDto.getId(),
            memberDto.getCreateDate(),
            memberDto.getModifyDate(),
            memberDto.getUsername(),
            memberDto.getNickname(),
            "",
            memberDto.getActivityScore()
        );
        cashMemberRepository.save(cashMember);
    }
}
