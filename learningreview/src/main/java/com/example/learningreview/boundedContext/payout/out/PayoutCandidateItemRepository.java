package com.example.learningreview.boundedContext.payout.out;

import com.example.learningreview.boundedContext.payout.domain.PayoutCandidateItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayoutCandidateItemRepository extends JpaRepository<PayoutCandidateItem, Integer> {
}
