package com.example.learningreview.boundedContext.post.out;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.boundedContext.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Integer> {
    public Optional<Post> findByAuthor(Member author);
}
