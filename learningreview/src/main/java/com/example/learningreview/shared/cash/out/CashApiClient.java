package com.example.learningreview.shared.cash.out;

import com.example.learningreview.shared.cash.dto.WalletDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CashApiClient {
    private RestClient restClient;

    public CashApiClient() {
        this.restClient = RestClient
                .builder()
                .baseUrl("http://localhost:8080/api/v1/cash")
                .build();
    }
    public WalletDto getItemByHolderId(int holderId){
        return restClient.get()
                .uri("wallets/by-holder/%d".formatted(holderId))
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }
    public long getBalanceByHolderId(int holderId) {
        WalletDto walletDto = getItemByHolderId(holderId);
        return walletDto.getBalance();
    }
}
