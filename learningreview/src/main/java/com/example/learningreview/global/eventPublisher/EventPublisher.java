package com.example.learningreview.global.eventPublisher;

import com.example.learningreview.shared.post.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventPublisher {

    private final ApplicationEventPublisher publisher;
    public void publish(Object event){
        publisher.publishEvent(event);
    }

}
