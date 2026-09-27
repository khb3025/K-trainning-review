package com.example.learningreview.boundedContext.payout.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class PayoutPolicy {

    public static int PAYOUT_READY_WAITING_DAYS;

    @Value("${custom.payout.readyWaitingDays:}")
    public void setPayoutReadyWaitingDays(int payoutReadyWaitingDays){
        PAYOUT_READY_WAITING_DAYS = payoutReadyWaitingDays;
    }

}
