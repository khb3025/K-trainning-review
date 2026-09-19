package com.example.learningreview.boundedContext.post.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "POST_POST_MEMBER")
public class PostMember extends BaseIdAndTime {
    @Column(unique = true)
    private String username;
    private String nickname;
    private String password;
    private int activityScore;

    public PostMember(
            String username,
            String password,
            String nickname,
            int activityScore
    ) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.activityScore = activityScore;
    }
}
