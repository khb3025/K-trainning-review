package com.example.learningreview.boundedContext.post.domain;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;

import static jakarta.persistence.GenerationType.IDENTITY;


@Entity
@Getter
public class PostComment extends BaseIdAndTime {

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @Column(columnDefinition = "TEXT")
    private String content;

    protected PostComment() {}

    public PostComment(Post post, Member author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }
}
