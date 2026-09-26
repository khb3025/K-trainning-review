package com.example.learningreview.shared.post.out;

import com.example.learningreview.shared.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
public class PostApiClient {
    private final RestClient restClient;

    public PostApiClient(
            @Value("${custom.global.internalBackUrl}")
            String baseUrl
    ){
        this.restClient = RestClient
                .builder()
                .baseUrl(baseUrl+"/api/v1/post")
                .build();
    }

    public List<PostDto> getItems(){
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

    public PostDto getItem(int id){
        return restClient.get()
                .uri("/posts/%d".formatted(id))
                .retrieve()
                .body(new ParameterizedTypeReference<>(){});
    }

}
