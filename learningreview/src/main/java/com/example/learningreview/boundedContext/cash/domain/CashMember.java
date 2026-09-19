package com.example.learningreview.boundedContext.cash.domain;

import com.example.learningreview.shared.member.domain.ReplicaMember;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Entity
@Getter
@Table(name = "CASH_CASH_MEMBER")
public class CashMember extends ReplicaMember {
    public CashMember(
            int id,
            LocalDateTime createDate,
            LocalDateTime modifyDate,
            String username,
            String nickname,
            String password,
            int activityScore
    ){
        super(
                id,
                createDate,
                modifyDate,
                username,
                nickname,
                "",
                activityScore
        );
    }
}
