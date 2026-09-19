package com.example.learningreview.global.global;

import com.example.learningreview.global.eventPublisher.EventPublisher;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GlobalConfig {
    @Getter
    private static EventPublisher eventPublisher;
    @Autowired
    public void setEventPublish(EventPublisher eventPublisher){
        GlobalConfig.eventPublisher = eventPublisher;
    }

}
