package com.example.learningreview.boundedContext.member.out;

import com.example.learningreview.boundedContext.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
