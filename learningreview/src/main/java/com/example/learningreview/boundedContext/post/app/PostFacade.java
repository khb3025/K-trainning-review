package com.example.learningreview.boundedContext.post.app;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.boundedContext.post.out.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostFacade {
    private final PostRepository postRepository;

    @Transactional
    public void write(Member author, String title, String content){
        postRepository.save(new Post(author, title, content));

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
