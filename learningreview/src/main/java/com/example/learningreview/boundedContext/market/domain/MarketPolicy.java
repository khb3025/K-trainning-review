package com.example.learningreview.boundedContext.market.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MarketPolicy {
    static double PRODUCT_PAYOUT_RATE = 90;
    @Value("${market.product.payout.rate}")
    void setProductPayoutRate(double rate){
        PRODUCT_PAYOUT_RATE = rate;
    }
}
