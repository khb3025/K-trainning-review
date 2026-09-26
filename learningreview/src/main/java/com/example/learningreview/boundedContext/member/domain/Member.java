package com.example.learningreview.boundedContext.member.domain;

import com.example.learningreview.global.jpa.entity.BaseIdAndTime;
import com.example.learningreview.shared.member.domain.SourceMember;
import com.example.learningreview.shared.member.dto.MemberDto;
import com.example.learningreview.shared.member.event.MemberModifiedEvent;
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
public class Member extends SourceMember {

    public Member(
        String nickname,
        String password,
        String username
    ) {
        super(
            username,
            nickname,
            password
        );
    }

    public int increaseActivityScore(int amount){
        if(amount <= 0) return getActivityScore();
        setActivityScore(getActivityScore() + amount);
        publishEvent(new MemberModifiedEvent(this.toDto()));
        return getActivityScore();
    }

    public MemberDto toDto(){
        return new MemberDto(
                getId(),
                getCreateDate(),
                getModifyDate(),
                getUsername(),
                getNickname(),
                getActivityScore()
        );
    }
}
