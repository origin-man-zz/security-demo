package com.test.securitydemo.api;

import com.test.securitydemo.api.dto.MemberDto;
import com.test.securitydemo.domain.Member;
import com.test.securitydemo.repository.MemberRepository;
import com.test.securitydemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;



    @PostMapping
    public Member create(@RequestBody MemberDto memberDto) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Member member = Member.builder()
                .id(memberDto.getId())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .name(memberDto.getName())
                .build();

        return memberService.addMember(member);
    }

    @GetMapping
    public String result(String id) {
        return "121212";
    }

    @PutMapping
    public String result2(String id) {
        return "34343434";
    }
}
