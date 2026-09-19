package com.example.learningreview.boundedContext.post.in;

import com.example.learningreview.boundedContext.member.app.MemberFacade;
import com.example.learningreview.boundedContext.post.app.PostFacade;
import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.boundedContext.post.domain.PostMember;
import com.example.learningreview.global.RsData.RsData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

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
            self.makeBasePostComments();
        };
    }
    @Transactional
    public void makeBasePosts() {
        if (postFacade.count() > 0) return;

        // user1 회원(4번 회원)이 글 3개 작성
        PostMember author1 = postFacade.findByUsername("user1").get();
        RsData<Post> RsDataPost1 = postFacade.write(author1, "제목1", "내용1");
        log.debug("Post1RsData : {}", RsDataPost1.getMsg());
        RsData<Post> RsDataPost2 = postFacade.write(author1, "제목2", "내용2");
        log.debug("Post2RsData : {}", RsDataPost2.getMsg());
        RsData<Post> RsDataPost3 = postFacade.write(author1, "제목3", "내용3");
        log.debug("Post3RsData : {}", RsDataPost3.getMsg());


        // user2 회원(5번 회원)이 글 2개 작성
        PostMember author2 = postFacade.findByUsername("user2").get();
        Post post4 = postFacade.write(author2, "제목4", "내용4").getData();
        Post post5 = postFacade.write(author2, "제목5", "내용5").getData();

        // user3 회원(6번 회원)이 글 1개 작성
        PostMember author3 = postFacade.findByUsername("user3").get();
        Post post6 = postFacade.write(author3, "제목6", "내용6").getData();

    }

    @Transactional
    public void makeBasePostComments() {

        Post post1 = postFacade.findById(1).get();
        Post post2 = postFacade.findById(2).get();
        Post post3 = postFacade.findById(3).get();
        Post post4 = postFacade.findById(4).get();
        Post post5 = postFacade.findById(5).get();
        Post post6 = postFacade.findById(6).get();

        // user1 회원(4번 회원)이 글 3개 작성
        PostMember author1 = postFacade.findByUsername("user1").get();
        PostMember author2 = postFacade.findByUsername("user2").get();
        PostMember author3 = postFacade.findByUsername("user3").get();

        if( post1.hasComments() ) return;

        post1.addComment(author1, "댓글1");
        post1.addComment(author2, "댓글2");
        post1.addComment(author3, "댓글3");

        post2.addComment(author2, "댓글4");
        post2.addComment(author2, "댓글5");

        post3.addComment(author3, "댓글6");
        post3.addComment(author1, "댓글7");

        post4.addComment(author1, "댓글8");

    }
}
