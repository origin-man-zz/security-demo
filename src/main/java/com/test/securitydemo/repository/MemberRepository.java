package com.test.securitydemo.repository;

import java.util.Optional;

import com.test.securitydemo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findMemberById(String id);
}
