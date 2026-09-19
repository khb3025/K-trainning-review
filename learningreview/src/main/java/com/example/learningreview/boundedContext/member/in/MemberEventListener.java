package com.example.learningreview.boundedContext.member.in;

import com.example.learningreview.boundedContext.app.MemberFacade;
import com.example.learningreview.boundedContext.member.domain.Member;
import com.example.learningreview.shared.post.event.PostCommentCreatedEvent;
import com.example.learningreview.shared.post.event.PostCreatedEvent;
import jakarta.persistence.EntityListeners;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static org.springframework.transaction.event.TransactionPhase.AFTER_COMMIT;

@Component
@RequiredArgsConstructor
public class MemberEventListener {

    private final MemberFacade memberFacade;

    @TransactionalEventListener( phase = AFTER_COMMIT)
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(PostCreatedEvent event) {
        Member member = memberFacade.findById(event.getPostDto().getAuthorId()).get();
        member.increaseActivityScore(3);
    }

    @TransactionalEventListener( phase = AFTER_COMMIT)
    @Transactional(propagation = REQUIRES_NEW)
    public void handle(PostCommentCreatedEvent event) {
        Member member = memberFacade.findById(event.getPostCommentDto().getAuthorId()).get();
        member.increaseActivityScore(1);
    }
}
