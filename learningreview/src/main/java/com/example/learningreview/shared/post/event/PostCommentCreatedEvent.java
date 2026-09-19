package com.example.learningreview.shared.post.event;

import com.example.learningreview.shared.post.dto.PostCommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class PostCommentCreatedEvent {
    private final PostCommentDto postCommentDto;
}
