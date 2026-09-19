package com.example.learningreview.boundedContext.post.domain;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;


@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "POST_POST_COMMENT")
public class PostComment extends BaseIdAndTime {

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @Column(columnDefinition = "TEXT")
    private String content;

    public PostComment(Post post, Member author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }


}
