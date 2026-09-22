package com.example.learningreview.global.jpa.entity;

import com.example.learningreview.global.global.GlobalConfig;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class BaseEntity {
    public abstract int getId();
    public abstract LocalDateTime getCreateDate();
    public abstract LocalDateTime getModifyDate();

    public String getModelTypeCode(){
        return getClass().getSimpleName();
    }

    public void publishEvent(Object event){
        GlobalConfig.getEventPublisher().publish(event);
    }
}
