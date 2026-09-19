package com.example.learningreview.boundedContext.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.member.out.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberRepository memberRepository;

    @Transactional
    public void join(String nickname, String password, String username){
        memberRepository.save(new Member(
            nickname,
            password,
            username
        ));
    }
}
