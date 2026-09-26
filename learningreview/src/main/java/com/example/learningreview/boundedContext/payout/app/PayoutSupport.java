package com.example.learningreview.boundedContext.payout.app;

import com.example.learningreview.boundedContext.payout.domain.PayoutMember;
import com.example.learningreview.boundedContext.payout.out.PayoutMemberRepository;
import com.example.learningreview.boundedContext.payout.out.PayoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PayoutSupport {
    private final PayoutMemberRepository payoutMemberRepository;
    public Optional<PayoutMember> findSystemMember(){
        return payoutMemberRepository.findByUsername("system");
    }
    public Optional<PayoutMember> findMemberById(int id){
        return payoutMemberRepository.findById(id);
    }

}
