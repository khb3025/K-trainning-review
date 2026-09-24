package com.example.learningreview.boundedContext.market.app;

import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.boundedContext.market.out.MarketMemberRepository;
import com.example.learningreview.boundedContext.market.domain.Product;
import com.example.learningreview.boundedContext.market.out.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MarketCreateProductUseCase {
    private final ProductRepository productRepository;

    public Product createProduct(
            MarketMember seller,
            String sourceTypeCode,
            int sourceId,
            String name,
            String description,
            long price,
            long salePrice
    ) {

        return productRepository.save(new Product(
                seller,
                sourceTypeCode,
                sourceId,
                name,
                description,
                price,
                salePrice
        ));
    }
}
