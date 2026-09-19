package com.example.learningreview.shared.member.out;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MemberApiClient {
    private RestClient restClient;

    public MemberApiClient() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:8080/api/v1/member/members")
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
