package com.example.learningreview.shared.market.dto;

import com.example.learningreview.boundedContext.market.domain.Order;
import com.example.learningreview.standard.HasModelTypeCode;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class OrderDto implements HasModelTypeCode {
    private final int id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private final int buyerId;
    private final String buyerName;
    private final long price;
    private final long salePrice;
    private final LocalDateTime requestPaymentDate;
    private final LocalDateTime paymentDate;


    @Override
    public String getModelTypeCode() {
        return "Order";
    }
}
