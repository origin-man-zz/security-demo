package com.test.securitydemo.service;


import com.test.securitydemo.domain.Member;
import com.test.securitydemo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public void getMember() {

    }
}
