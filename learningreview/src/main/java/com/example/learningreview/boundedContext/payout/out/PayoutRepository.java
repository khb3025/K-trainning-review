package com.example.learningreview.boundedContext.payout.out;

import com.example.learningreview.boundedContext.payout.domain.Payout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayoutRepository extends JpaRepository<Payout,Integer> {
}
