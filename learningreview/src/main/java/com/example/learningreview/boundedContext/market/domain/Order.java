package com.example.learningreview.boundedContext.market.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
@Table(name="MARKET_ORDER")
public class Order extends BaseIdAndTime {
    @ManyToOne(fetch= LAZY)
    private MarketMember buyer;
    long price;
    long salePrice;
    @OneToMany(
            mappedBy = "order",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            orphanRemoval = true
    )
    List<OrderItem> items = new ArrayList<>();

    public Order(Cart cart) {
        this.buyer = cart.getBuyer();
        cart.getItems().forEach(item -> {
            this.addItem(item.getProduct());
        });
    }

    public void addItem(Product product){
        OrderItem orderItem = new OrderItem(
                this,
                product,
                product.getName(),
                product.getPrice(),
                product.getSalePrice()
        );

        items.add(orderItem);

        price += orderItem.getPrice();
        salePrice += orderItem.getSalePrice();
    }
}
