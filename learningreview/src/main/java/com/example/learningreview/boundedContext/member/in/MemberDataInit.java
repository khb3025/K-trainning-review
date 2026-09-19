package com.example.learningreview.boundedContext.member.in;

import com.example.learningreview.boundedContext.member.app.MemberFacade;
import com.example.learningreview.boundedContext.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@Slf4j
public class MemberDataInit {

    private final MemberDataInit self;
    private final MemberFacade memberFacade;

    public MemberDataInit(
        @Lazy MemberDataInit self,
        MemberFacade memberFacade
    ) {
        this.self = self;
        this.memberFacade = memberFacade;
    }

    @Bean
    @Order(1)
    public ApplicationRunner MemberDataInitApplicationRunner(){
        return args -> {
            self.makeBaseMembers();
        };
    }
    @Transactional
    public void makeBaseMembers(){
        if(memberFacade.count() > 0) return;
        Member member1 = memberFacade.join("시스템","1234","system").getData();
        log.debug("member1 : {}", member1.getUsername());
        Member member2 = memberFacade.join("홀딩","1234","holding").getData();
        Member member3 = memberFacade.join("관리자","1234","admin").getData();
        Member member4 = memberFacade.join("유저1","1234","user1").getData();
        Member member5 = memberFacade.join("유저2","1234","user2").getData();
        Member member6 = memberFacade.join("유저3","1234","user3").getData();
    }
}
