package com.timeSNSTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timeSNSTest.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{

}
