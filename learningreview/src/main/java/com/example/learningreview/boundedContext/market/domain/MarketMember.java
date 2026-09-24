package com.example.learningreview.boundedContext.market.domain;

import com.example.learningreview.shared.member.domain.ReplicaMember;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.print.Pageable;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name="MARKET_MEMBER")
@Getter
public class MarketMember extends ReplicaMember {

    public MarketMember(
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
