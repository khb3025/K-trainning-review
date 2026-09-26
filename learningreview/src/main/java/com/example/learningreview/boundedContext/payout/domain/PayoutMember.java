package com.example.learningreview.boundedContext.payout.domain;

import com.example.learningreview.global.jpa.entity.BaseEntity;
import com.example.learningreview.global.jpa.entity.BaseManualIdAndTime;
import com.example.learningreview.shared.member.domain.ReplicaMember;
import com.example.learningreview.shared.payout.dto.PayoutMemberDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Table(name = "PAYOUT_MEMBER")
@Entity
public class PayoutMember extends ReplicaMember {
    public PayoutMember(
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

    public PayoutMemberDto toDto(){
        return new PayoutMemberDto(
                getId(),
                getCreateDate(),
                getModifyDate(),
                getUsername(),
                getNickname(),
                getActivityScore()
        );
    }
}
