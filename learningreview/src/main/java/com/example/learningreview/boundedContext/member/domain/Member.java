package com.example.learningreview.boundedContext.member.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@AllArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = IDENTITY)
    private int id;

    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;

    private String nickname;
    private String password;
    private String username;

    protected Member() {}

    public Member(String nickname, String password, String username) {
        this.nickname = nickname;
        this.password = password;
        this.username = username;
    }
}
