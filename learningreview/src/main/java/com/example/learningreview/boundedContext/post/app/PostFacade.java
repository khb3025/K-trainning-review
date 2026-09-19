package com.example.learningreview.boundedContext.post.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.boundedContext.post.out.PostRepository;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import com.example.learningreview.shared.post.dto.PostDto;
import com.example.learningreview.shared.post.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostRepository postRepository;
    private final EventPublisher eventPublisher;

    @Transactional
    public Post write(Member author, String title, String content){
        Post post = new Post(author, title, content);
        // author.increaseActivityScore(3);
        eventPublisher.publish(new PostCreatedEvent(new PostDto(post)));
        return postRepository.save(post);
    }

    @Transactional(readOnly = true)
    public long count(){
        return postRepository.count();
    }
    @Transactional(readOnly = true)
    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }
}
