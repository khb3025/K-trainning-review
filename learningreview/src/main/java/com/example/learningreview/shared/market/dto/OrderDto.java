package com.example.learningreview.shared.market.dto;

import com.example.learningreview.boundedContext.market.domain.Order;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor(
        onConstructor_ = @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
)
@Getter
public class OrderDto {
    private final int id;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private final int buyerId;
    private final String buyerName;
    private final long price;
    private final long salePrice;
    private final LocalDateTime requestPaymentDate;
    private final LocalDateTime paymentDate;

    public OrderDto(Order order) {
        this(
            order.getId(),
            order.getCreateDate(),
            order.getModifyDate(),
            order.getBuyer().getId(),
            order.getBuyer().getUsername(),
            order.getPrice(),
            order.getSalePrice(),
            order.getRequestPaymentDate(),
            order.getPaymentDate()
        );
    }
}
