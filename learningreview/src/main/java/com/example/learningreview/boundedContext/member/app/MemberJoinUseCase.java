package com.example.learningreview.boundedContext.member.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.member.out.MemberRepository;
import com.example.learningreview.global.RsData.RsData;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import com.example.learningreview.shared.member.dto.MemberDto;
import com.example.learningreview.shared.member.event.MemberJoinedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberJoinUseCase {

    private final MemberRepository memberRepository;
    private final EventPublisher eventPublisher;

    public RsData<Member> join(String nickname, String password, String username) {
        Member joinMember = new Member(
             nickname,
             password,
             username
        );
        memberRepository.save(joinMember);
        // 동기화 이벤트 발행
        eventPublisher.publish(new MemberJoinedEvent(joinMember.toDto()));
        return new RsData<>("200-1","%d번째 회원가입 성공".formatted(joinMember.getId()), joinMember);
    }
}
