package com.timeSNSTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.timeSNSTest.domain.Member;
import com.timeSNSTest.repository.MemberRepository;

@SpringBootTest
class TimeSnsTestApplicationTests {

	@Autowired
	private MemberRepository memberRepository; 
	
	@Test
	void contextLoads() {
	
		Member member = new Member();
		
		member.setId("cws1234");
		member.setPwd("s!940408");
		
		memberRepository.save(member);	
		System.out.println("/get2.do 값");
		memberRepository.findAll().forEach(System.out::println);
	
	}

}
