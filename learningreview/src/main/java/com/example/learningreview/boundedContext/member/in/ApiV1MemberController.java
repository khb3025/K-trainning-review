package com.example.learningreview.boundedContext.member.in;

import com.example.learningreview.boundedContext.app.MemberFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member/members")
public class ApiV1MemberController {

    private final MemberFacade memberFacade;

    @GetMapping("/randomSecureTip")
    public String randomSecureTip() {
        return memberFacade.getRandomSecureTip();
    }
}
