package com.example.learningreview.shared.payout.out;

import com.example.learningreview.shared.market.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class MarketApiClient {

    private final RestClient restClient;

    public MarketApiClient(
            @Value("${custom.global.internalBackUrl}")
            String baseUrl
    ){
        restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
    }

    public List<OrderItemDto> getOrderItems(int id){
        return restClient.get()
                .uri("/api/v1/market/orders/%d/items".formatted(id))
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }
}
