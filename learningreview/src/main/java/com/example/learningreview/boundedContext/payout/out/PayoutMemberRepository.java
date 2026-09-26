package com.example.learningreview.boundedContext.payout.out;


import com.example.learningreview.boundedContext.payout.domain.PayoutMember;
import com.example.learningreview.shared.member.dto.MemberDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PayoutMemberRepository extends JpaRepository<PayoutMember, Integer> {
    Optional<PayoutMember> findByUsername(String username);
}
