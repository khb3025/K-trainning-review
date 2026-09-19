package com.example.learningreview.boundedContext.cash.out;

import com.example.learningreview.boundedContext.cash.domain.CashMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashMemberRepository extends JpaRepository<CashMember, Integer> {
}
