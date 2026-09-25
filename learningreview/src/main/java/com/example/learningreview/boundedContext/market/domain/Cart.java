package com.example.learningreview.boundedContext.market.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import com.example.learningreview.global.jpa.entity.BaseManualIdAndTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="MARKET_CART")
public class Cart extends BaseManualIdAndTime {
    @ManyToOne(fetch = FetchType.LAZY)
    private MarketMember buyer;
    @OneToMany(
            mappedBy = "cart",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
            orphanRemoval = true
    )
    private List<CartItem> items = new ArrayList<>();
    int itemsCount;

    public Cart(
        MarketMember buyer
    ) {
        super(buyer.getId());
        this.buyer = buyer;
    }

    public void addItem(Product product){
        CartItem cartItem = new CartItem(this, product);
        this.getItems().add(cartItem);
        this.itemsCount++;

    }

    public boolean hasItems(){
        return !items.isEmpty();
    }

    public void clearItems() {
        this.getItems().clear();
    }
}
