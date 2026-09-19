package com.example.learningreview.shared.member.domain;

import com.example.learningreview.global.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@Getter
public abstract class BaseMember extends BaseEntity {
    @Column(unique = true)
    private String username;
    private String nickname;
    private String password;
    private int activityScore;

    public BaseMember(
        String username,
        String nickname,
        String password,
        int activityScore
    ) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.activityScore = activityScore;
    }
}
