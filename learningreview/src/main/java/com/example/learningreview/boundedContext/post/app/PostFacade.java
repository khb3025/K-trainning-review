package com.example.learningreview.boundedContext.post.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.boundedContext.post.out.PostRepository;
import com.example.learningreview.global.RsData.RsData;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostRepository postRepository;
    private final EventPublisher eventPublisher;
    private final PostWriteUseCase postUseCase;

    @Transactional
    public RsData<Post> write(Member author, String title, String content){
        return postUseCase.write(author, title, content);
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
