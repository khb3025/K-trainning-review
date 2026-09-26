package com.example.learningreview.shared.post.dto;

import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.global.jpa.entity.BaseEntity;
import com.example.learningreview.standard.HasModelTypeCode;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostDto implements HasModelTypeCode {
    private final int id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private final int authorId;
    private final String authorName;
    private final String title;
    private final String content;


    @Override
    public String getModelTypeCode() {
        return "Post";
    }
}
