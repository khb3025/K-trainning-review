package com.example.learningreview.boundedContext.post.out;

import com.example.learningreview.boundedContext.post.domain.PostMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostMemberRepository extends JpaRepository<PostMember, Integer> {
}
