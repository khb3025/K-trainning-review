package com.example.learningreview.boundedContext.market.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@Table(name="MARKET_ORDER_ITEMS")
public class OrderItem extends BaseIdAndTime {

    @ManyToOne(fetch= LAZY)
    private Order order;
    @ManyToOne(fetch= LAZY)
    private Product product;
    private String productName;
    private long price;
    private long salePrice;
    private double payoutRate = MarketPolicy.PRODUCT_PAYOUT_RATE;

    public OrderItem(
            Order order,
            Product product,
            String productName,
            long price,
            long salePrice)
    {
        this.order = order;
        this.product = product;
        this.productName = productName;
        this.price = price;
        this.salePrice = salePrice;
    }
}
