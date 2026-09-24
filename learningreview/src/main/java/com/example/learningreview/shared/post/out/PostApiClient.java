package com.example.learningreview.shared.post.out;

import com.example.learningreview.shared.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostApiClient {
    private final RestClient restClient;

    public PostApiClient(){
        this.restClient = RestClient
                .builder()
                .baseUrl("http://localhost:8080/api/v1/post")
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
