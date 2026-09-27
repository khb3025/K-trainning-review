package com.example.learningreview.boundedContext.payout.out;

import com.example.learningreview.boundedContext.payout.domain.Payout;
import com.example.learningreview.boundedContext.payout.domain.PayoutMember;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PayoutRepository extends JpaRepository<Payout,Integer> {
    Optional<Payout> findByPayeeAndPayoutDateIsNull(PayoutMember payee);
    List<Payout> findByPayoutDateIsNullAndAmountGreaterThanOrderByIdAsc(long amount, Pageable pageable);
}
