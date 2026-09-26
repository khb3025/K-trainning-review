package com.example.learningreview.boundedContext.cash.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CashPolicy {
    public static int HOLDING_MEMBER_ID = 2;

    @Value("${cash.holding.member.id}")
    void setHoldingMemberId(int id){
        HOLDING_MEMBER_ID = id;
    }
}
