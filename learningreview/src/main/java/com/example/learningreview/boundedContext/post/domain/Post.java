package com.example.learningreview.boundedContext.post.domain;

import com.example.learningreview.boundedContext.member.domain.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
public class Post {
    @Id @GeneratedValue(strategy = IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    private String title;
    private String content;

    protected Post() {}
    public Post(Member author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }
}
