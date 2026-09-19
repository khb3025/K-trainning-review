package com.example.learningreview.boundedContext.post.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import com.example.learningreview.shared.post.dto.PostCommentDto;
import com.example.learningreview.shared.post.event.PostCommentCreatedEvent;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "POST_POST")
public class Post extends BaseIdAndTime {
    @ManyToOne(fetch = FetchType.LAZY)
    private PostMember author;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @OneToMany(mappedBy = "post", cascade = {REMOVE, PERSIST}, orphanRemoval = true)
    private List<PostComment> comments = new ArrayList<>();

    public Post(PostMember author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public PostComment addComment(PostMember author, String content){
        PostComment postComment = new PostComment(this, author, content);
        comments.add(postComment);
        publishEvent(new PostCommentCreatedEvent(new PostCommentDto(postComment)));
        return postComment;
    }

    public boolean hasComments() {

        return !comments.isEmpty();
    }
}
