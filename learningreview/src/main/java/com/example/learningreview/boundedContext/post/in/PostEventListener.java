package com.example.learningreview.boundedContext.post.in;

import com.example.learningreview.boundedContext.post.app.PostFacade;
import com.example.learningreview.boundedContext.post.domain.PostMember;
import com.example.learningreview.global.eventPublisher.EventPublisher;
import com.example.learningreview.shared.member.dto.MemberDto;
import com.example.learningreview.shared.member.event.MemberJoinedEvent;
import com.example.learningreview.shared.member.event.MemberModifiedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;


@Component
@RequiredArgsConstructor
public class PostEventListener {

    private final PostFacade postFacade;
    private final EventPublisher eventPublisher;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(MemberJoinedEvent event) {
        postFacade.syncMember(event.getMemberDto());
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(MemberModifiedEvent event) {
        postFacade.syncMember(event.getMemberDto());
    }

}
