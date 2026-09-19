package com.example.learningreview.boundedContext.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.member.out.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberRepository memberRepository;

    public long count(){
        return memberRepository.count();
    }

    @Transactional
    public void join(String nickname, String password, String username){
        memberRepository.save(new Member(
            nickname,
            password,
            username
        ));
    }

    public Optional<Member> findByUsername(String username){
        return memberRepository.findByUsername(username);
    }
}
