package com.example.learningreview.shared.market.dto;

import com.example.learningreview.boundedContext.market.domain.MarketMember;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class MarketMemberDto {
    private int id;
    private LocalDateTime creatDate;
    private LocalDateTime modifyDate;
    private String username;
    private String nickname;
    private int activityScore;

}
