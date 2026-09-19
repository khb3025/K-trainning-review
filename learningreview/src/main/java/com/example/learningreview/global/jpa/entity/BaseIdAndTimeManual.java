package com.example.learningreview.global.jpa.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@NoArgsConstructor
@Getter
public abstract class BaseIdAndTimeManual extends BaseEntity{
    @Id
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

}
