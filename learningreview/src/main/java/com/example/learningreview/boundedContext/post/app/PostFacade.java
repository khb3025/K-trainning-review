package com.example.learningreview.boundedContext.post.app;

import com.example.learningreview.boundedContext.post.domain.Post;
import com.example.learningreview.boundedContext.post.domain.PostMember;
import com.example.learningreview.boundedContext.post.out.PostMemberRepository;
import com.example.learningreview.boundedContext.post.out.PostRepository;
import com.example.learningreview.global.RsData.RsData;
import com.example.learningreview.shared.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostFacade {
    private final PostSyncMemberUseCase postSyncMemberUseCase;
    private final PostWriteUseCase postWriteUseCase;
    private final PostSupport postSupport;

    @Transactional
    public RsData<Post> write(PostMember author, String title, String content){
        return postWriteUseCase.write(author, title, content);
    }

    public long count(){
        return postSupport.count();
    }

    public Optional<Post> findById(int id){
        return postSupport.findById(id);
    }

    @Transactional
    public void syncMember(MemberDto memberDto) {
        postSyncMemberUseCase.syncMember(memberDto);
    }

    public Optional<PostMember> findByUsername(String username){
        return postSupport.findByUsername(username);
    }
}
