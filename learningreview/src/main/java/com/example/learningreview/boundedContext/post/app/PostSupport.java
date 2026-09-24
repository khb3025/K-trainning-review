package com.example.learningreview.boundedContext.post.app;

import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.boundedContext.post.domain.PostMember;
import com.example.learningreview.boundedContext.post.out.PostMemberRepository;
import com.example.learningreview.boundedContext.post.out.PostRepository;
import com.example.learningreview.shared.post.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostSupport {
    private final PostRepository postRepository;
    private final PostMemberRepository postMemberRepository;
    public long count(){
        return postRepository.count();
    }

    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }

    public Optional<PostMember> findByUsername(String username) {
        return postMemberRepository.findByUsername(username);
    }

    public List<Post> findByOrderByIdDesc() {
        return postRepository.findByOrderByIdDesc();
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }
}
