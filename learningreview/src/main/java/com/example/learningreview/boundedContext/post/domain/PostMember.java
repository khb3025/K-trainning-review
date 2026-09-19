package com.example.learningreview.boundedContext.post.domain;

import com.example.learningreview.shared.member.domain.ReplicaMember;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@Table(name = "POST_POST_MEMBER")
public class PostMember extends ReplicaMember {
    public PostMember(
            int id,
            LocalDateTime createDate,
            LocalDateTime modifyDate,
            String username,
            String nickname,
            String password,
            int activityScore
    ) {
        super(
            id,
            createDate,
            modifyDate,
            username,
            nickname,
            password,
            activityScore
        );

    }
}
