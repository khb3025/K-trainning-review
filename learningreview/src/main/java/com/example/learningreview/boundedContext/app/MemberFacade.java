package com.example.learningreview.boundedContext.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.member.out.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberFacade {

    private final MemberRepository memberRepository;
    private final MemberUseCase memberUseCase;

    public long count(){
        return memberRepository.count();
    }

    @Transactional
    public void join(String nickname, String password, String username){
        memberUseCase.join(nickname, password, username);

    }

    public Optional<Member> findByUsername(String username){
        return memberRepository.findByUsername(username);
    }

    public Optional<Member> findById(int id){
        return memberRepository.findById(id);
    }
}
