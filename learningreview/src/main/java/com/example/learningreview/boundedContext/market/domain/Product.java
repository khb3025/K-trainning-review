package com.example.learningreview.boundedContext.market.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;


@Getter
@Entity
@NoArgsConstructor
@Table(name="MARKET_PRODUCT")
public class Product extends BaseIdAndTime {
    @ManyToOne(fetch = LAZY)
    private MarketMember seller; // 판매자
    private String sourceTypeCode;  // 상품 타입 ( 글 타입 : POST )
    private int sourceId; // 등록상품ID(글Id - 참조값)
    private String name; // 상품명
    private String description; // 상품설명
    private long price; // 원가
    private long salePrice; // 현재 할인 판매가

    public Product(
            MarketMember marketMember,
            String sourceTypeCode,
            int sourceId,
            String name,
            String description,
            long price,
            long salePrice
    ){
        this.seller = marketMember;
        this.sourceTypeCode = sourceTypeCode;
        this.sourceId = sourceId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.salePrice = salePrice;
    }
}
