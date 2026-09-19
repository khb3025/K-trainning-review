package com.example.learningreview.boundedContext.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.member.out.MemberRepository;
import com.example.learningreview.global.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberUseCase {

    private final MemberRepository memberRepository;

    public RsData<Member> join(String nickname, String password, String username) {
         Member joinMember = new Member(
             nickname,
             password,
             username
         );
         memberRepository.save(joinMember);
         return new RsData<>("200-1","%d번째 회원가입 성공".formatted(joinMember.getId()), joinMember);
    }
}
