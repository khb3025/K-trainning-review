package com.example.learningreview.boundedContext.market.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import com.example.learningreview.shared.market.dto.OrderDto;
import com.example.learningreview.shared.market.event.MarketOrderPaymentRequestEvent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private LocalDateTime requestPaymentDate;
    private LocalDateTime paymentDate;
    private LocalDateTime cancelDate;
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

    public void completePayment(){
        paymentDate = LocalDateTime.now();
    }

    public boolean isPaid(){
        return paymentDate != null;
    }

    public void requestPayment(long pgPaymentAmount){
        requestPaymentDate = LocalDateTime.now();
        publishEvent(
                new MarketOrderPaymentRequestEvent(
                        this.toDto(),
                        pgPaymentAmount
                )
        );
    }

    public void cancelPayment(){
        paymentDate = null;
    }

    public boolean isCanceled(){
        return cancelDate != null;
    }

    public boolean isPaymentInProgress(){
        return requestPaymentDate != null && paymentDate == null && cancelDate == null;
    }

    public OrderDto toDto(){
        return new OrderDto(
                this.getId(),
                this.getCreateDate(),
                this.getModifyDate(),
                this.getBuyer().getId(),
                this.getBuyer().getUsername(),
                this.getPrice(),
                this.getSalePrice(),
                this.getRequestPaymentDate(),
                this.getPaymentDate()
        );
    }

}
