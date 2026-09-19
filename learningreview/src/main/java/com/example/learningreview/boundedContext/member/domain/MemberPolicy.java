package com.example.learningreview.boundedContext.member.domain;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class MemberPolicy {
    public static final int PASSWORD_CHANGE_LIMIT = 90;


    public int getNeedToChangePasswordDays() {
        return PASSWORD_CHANGE_LIMIT;
    }

    public Duration getNeedToChangePasswordPeriod(){
        return Duration.ofDays(PASSWORD_CHANGE_LIMIT);
    }

    public boolean isNeedToChangePassword(LocalDateTime lastChangeDate){
        return lastChangeDate.plusDays(getNeedToChangePasswordDays()).isBefore(LocalDateTime.now());
    }

}
