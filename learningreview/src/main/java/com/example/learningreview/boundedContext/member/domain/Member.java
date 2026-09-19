package com.example.learningreview.boundedContext.member.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "MEMBER_MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseIdAndTime {

    private String nickname;
    private String password;
    @Column(unique = true)
    private String username;
    private int activityScore; // int 는 설정안해도 기본 0 //Integer 는 null

    public Member(String nickname, String password, String username) {
        this.nickname = nickname;
        this.password = password;
        this.username = username;
    }

    public void increaseActivityScore(int amount){
        this.activityScore += amount;
    }
}
