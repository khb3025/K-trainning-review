package com.example.learningreview.shared.member.out;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MemberApiClient {
    private RestClient restClient;

    public MemberApiClient(
            @Value("${custom.global.internalBackUrl}") String baseUrl
    ) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl + "/api/v1/member/members")
                .build();
    }

    public String getRandomSecureTip() {
        return restClient
                .get()
                .uri("/randomSecureTip")
                .retrieve()
                .body(String.class);
    }
}
