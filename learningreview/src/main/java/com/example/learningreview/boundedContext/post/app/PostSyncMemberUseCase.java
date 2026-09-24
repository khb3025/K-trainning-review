package com.example.learningreview.boundedContext.post.app;

import com.example.learningreview.boundedContext.post.domain.PostMember;
import com.example.learningreview.boundedContext.post.out.PostMemberRepository;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostSyncMemberUseCase {

    private final PostMemberRepository postMemberRepository;

    @Transactional
    public void syncMember(MemberDto memberDto) {
        PostMember postMember = new PostMember(
                memberDto.getId(),
                memberDto.getCreateDate(),
                memberDto.getModifyDate(),
                memberDto.getUsername(),
                memberDto.getNickname(),
                "",
                memberDto.getActivityScore()
        );
        postMemberRepository.save(postMember);
    }
}
