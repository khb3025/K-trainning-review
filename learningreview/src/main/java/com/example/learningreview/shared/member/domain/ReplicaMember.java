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
            String username,
            String nickname,
            String password
    ){
        super(
                username,
                nickname,
                password
        );
    }

}
