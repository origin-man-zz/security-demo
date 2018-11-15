package com.test.securitydemo.api.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MemberDto {
    private Long idx;
    private String id;
    private String password;
    private String name;
}