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
public class PostFacade {
    private final PostRepository postRepository;
    private final PostMemberRepository postMemberRepository;
    private final PostWriteUseCase postUseCase;

    @Transactional
    public RsData<Post> write(PostMember author, String title, String content){
        return postUseCase.write(author, title, content);
    }

    @Transactional(readOnly = true)
    public long count(){
        return postRepository.count();
    }
    @Transactional(readOnly = true)
    public Optional<Post> findById(int id){
        return postRepository.findById(id);
    }

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

    public Optional<PostMember> findByUsername(String username){
        Optional<PostMember> postMember =  postMemberRepository.findByUsername(username);
        return postMember;
    }
}
