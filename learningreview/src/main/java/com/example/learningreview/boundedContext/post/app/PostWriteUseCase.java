package com.example.learningreview.boundedContext.post.app;

import com.example.learningreview.boundedContext.app.MemberFacade;
import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.boundedContext.post.out.PostRepository;
import com.example.learningreview.global.RsData.RsData;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import com.example.learningreview.shared.member.out.MemberApiClient;
import com.example.learningreview.shared.post.dto.PostDto;
import com.example.learningreview.shared.post.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostWriteUseCase {

    private final EventPublisher eventPublisher;
    private final PostRepository postRepository;
    // private final MemberFacade memberFacade;
    private final MemberApiClient memberApiClient;

    public RsData<Post> write(Member author, String title, String content) {
        Post post = new Post(author, title, content);
        // author.increaseActivityScore(3);
        postRepository.save(post);
        eventPublisher.publish(new PostCreatedEvent(new PostDto(post)));
        String secureTip = memberApiClient.getRandomSecureTip();
        return new RsData<>(
    "200-1",
             "%d번째 게시글이 작성되었습니다. 보안 팁 : %s".formatted(
                post.getId(),
                secureTip
             ),
             post
        );
    }
}
