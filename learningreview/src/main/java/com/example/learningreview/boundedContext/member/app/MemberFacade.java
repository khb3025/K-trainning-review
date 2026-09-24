package com.example.learningreview.boundedContext.member.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.global.RsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberFacade {

    private final MemberJoinUseCase memberJoinUseCase;
    private final MemberGetRandomSecureTipUseCase memberGetRandomSecureTipUseCase;
    private final MemberSupport memberSupport;

    public long count(){
        return memberSupport.count();
    }

    @Transactional
    public RsData<Member> join(String nickname, String password, String username){
        return memberJoinUseCase.join(nickname, password, username);
    }

    public Optional<Member> findByUsername(String username){
        return memberSupport.findByUsername(username);
    }

    public Optional<Member> findById(int id){
        return memberSupport.findById(id);
    }

    public String getRandomSecureTip(){
        return  memberGetRandomSecureTipUseCase.getRandomSecureTip();
    }
}
