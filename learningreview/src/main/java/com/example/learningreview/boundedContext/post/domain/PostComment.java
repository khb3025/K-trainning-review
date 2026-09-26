package com.example.learningreview.boundedContext.post.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import com.example.learningreview.shared.post.dto.PostCommentDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;


@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "POST_POST_COMMENT")
public class PostComment extends BaseIdAndTime {

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    private PostMember author;

    @Column(columnDefinition = "TEXT")
    private String content;

    public PostComment(Post post, PostMember author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }

    public PostCommentDto toDto(){
        return new PostCommentDto(
                getId(),
                getCreateDate(),
                getModifyDate(),
                post.getId(),
                author.getId(),
                author.getUsername(),
                content
        );
    }
}
