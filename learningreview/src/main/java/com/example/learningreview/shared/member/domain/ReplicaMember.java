package com.example.learningreview.shared.member.domain;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class ReplicaMember extends BaseMember{
    @Id
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    public ReplicaMember(
            int id,
            LocalDateTime createDate,
            LocalDateTime modifyDate,
            String username,
            String nickname,
            String password,
            int activityScore
    ){
        super(
                username,
                nickname,
                password,
                activityScore
        );
        this.id = id;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }

}
