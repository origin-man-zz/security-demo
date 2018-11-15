package com.test.securitydemo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

@Getter
@Setter
public class SecurityMember extends User {

    public SecurityMember(Member member) {
        super(member.getId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getPassword()));
    }
}
