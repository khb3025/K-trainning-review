package com.example.learningreview.boundedContext.post.domain;

import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import com.example.learningreview.shared.post.dto.PostCommentDto;
import com.example.learningreview.shared.post.event.PostCommentCreatedEvent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@AllArgsConstructor
public class Post extends BaseIdAndTime {
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @OneToMany(mappedBy = "post", cascade = {REMOVE, PERSIST}, orphanRemoval = true)
    private List<PostComment> comments = new ArrayList<>();

    protected Post() {}
    public Post(Member author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public PostComment addComment(Member author, String content){
        PostComment postComment = new PostComment(this, author, content);
        comments.add(postComment);
        publishEvent(new PostCommentCreatedEvent(new PostCommentDto(postComment)));
        return postComment;
    }

    public boolean hasComments() {

        return !comments.isEmpty();
    }
}
