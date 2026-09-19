package com.example.learningreview.shared.post.event;

import com.example.learningreview.shared.post.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class PostCreatedEvent {
    private final PostDto postDto;
}
