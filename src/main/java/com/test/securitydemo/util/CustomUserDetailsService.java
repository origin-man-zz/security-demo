package com.test.securitydemo.util;

import com.test.securitydemo.domain.Member;
import com.test.securitydemo.domain.SecurityMember;
import com.test.securitydemo.repository.MemberRepository;
import com.test.securitydemo.service.MemberNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        System.out.println(id);
        SecurityMember m = memberRepository.findMemberById(id)
                .filter(member -> member != null)
                .map(member -> new SecurityMember(member))
                .orElseThrow(MemberNotFoundException::new);
        return  m;
    }
}
