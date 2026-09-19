package com.example.learningreview.global.jpa.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners( AuditingEntityListener.class)
@Getter
public abstract class BaseManualIdAndTime extends BaseEntity{

    @Id
    private int id;
    @CreatedDate
    private LocalDateTime createDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;

    public BaseManualIdAndTime(int id){
        this.id = id;
    }
}
