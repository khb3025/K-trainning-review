package com.example.learningreview.boundedContext.post.in;

import com.example.learningreview.boundedContext.app.MemberFacade;
import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.post.app.PostFacade;
import com.example.learningreview.boundedContext.post.domain.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;

@Configuration
@Slf4j
public class PostDataInit {

    private final PostDataInit self;
    private final PostFacade postFacade;
    private final MemberFacade memberFacade;

    public PostDataInit(
        @Lazy PostDataInit self,
        PostFacade postFacade,
        MemberFacade memberFacade) {
        this.self = self;
        this.postFacade = postFacade;
        this.memberFacade = memberFacade;
    }

    @Bean
    @Order(2)
    public ApplicationRunner postDataInitApplicationRunner(){
        return args -> {
            self.makeBasePosts();
        };
    }

    public void makeBasePosts() {
        if (postFacade.count() > 0) return;

        // user1 회원(4번 회원)이 글 3개 작성
        Member author1 = memberFacade.findByUsername("user1").get();
        postFacade.write(author1, "제목1", "내용1");
        postFacade.write(author1, "제목2", "내용2");
        postFacade.write(author1, "제목3", "내용3");

        // user2 회원(5번 회원)이 글 2개 작성
        Member author2 = memberFacade.findByUsername("user2").get();
        postFacade.write(author2, "제목4", "내용4");
        postFacade.write(author2, "제목5", "내용5");

        // user3 회원(6번 회원)이 글 1개 작성
        Member author3 = memberFacade.findByUsername("user3").get();
        postFacade.write(author3, "제목6", "내용6");

    }

}
