package com.example.learningreview.boundedContext.market.in;

import com.example.learningreview.boundedContext.market.app.MarketFacade;
import com.example.learningreview.boundedContext.market.domain.MarketMember;
import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.shared.post.dto.PostDto;
import com.example.learningreview.shared.post.out.PostApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Configuration
@Slf4j
public class MarketDataInit {

    private final MarketDataInit self;
    private final MarketFacade marketFacade;
    private final PostApiClient postApiClient;
    public MarketDataInit(
        @Lazy MarketDataInit self,
        MarketFacade marketFacade,
        PostApiClient postApiClient
    ){
        this.self = self;
        this.marketFacade = marketFacade;
        this.postApiClient = postApiClient;
    }

    public ApplicationRunner marketDataInitApplicationRunner(){
        return args -> {
            self.makeBaseProducts();
        };
    }

    private void makeBaseProducts() {
        // 상품(글) 찾기 전체 조회 Id 값만 출력
        postApiClient.getItems().forEach(post -> {
            System.out.println("postId = " + post.getId());
        });
    }
}
