package com.test.securitydemo.service;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException() {
        super("member not found");
    }
}
