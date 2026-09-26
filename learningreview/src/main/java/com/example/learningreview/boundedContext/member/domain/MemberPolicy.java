package com.example.learningreview.boundedContext.member.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class MemberPolicy {
    public static int PASSWORD_CHANGE_LIMIT;

    @Value("${member.password.change.days}")
    public void setPasswordChangeDays(int days){
        PASSWORD_CHANGE_LIMIT = days;
    }

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
