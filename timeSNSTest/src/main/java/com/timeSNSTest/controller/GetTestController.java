package com.timeSNSTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timeSNSTest.domain.Member;
import com.timeSNSTest.domain.User;
import com.timeSNSTest.repository.MemberRepository;
import com.timeSNSTest.repository.UserRepository;

@RestController
@RequestMapping("/timeg")
public class GetTestController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@GetMapping("/get.do")
	public User getTest(User user) {
		
		user.setName("손준영");
		user.setEmail("junyoung940408@gmail.com");
		
		userRepository.save(user);
		System.out.println("/get.do 값");
		userRepository.findAll().forEach(System.out::println);

		return user;
	}
	
	@GetMapping("/get2.do")
	public String getTest2(Member member) {
		
		member.setId("junyoung940408");
		member.setPwd("s!940408");
		member.setGrade("USER");
		
		memberRepository.save(member);	
		System.out.println("/get2.do 값");
		memberRepository.findAll().forEach(System.out::println);

		return "redirect:/login";
		
	}
	
	@GetMapping("/get3.do")
	public User getTest3() {
		
		User user = new User();
		
		user.setName("테스트용 이름");
		user.setEmail("testId@gmail.com");
		
		userRepository.save(user);	
		System.out.println("/get3.do 값");
		userRepository.findAll().forEach(System.out::println);

		return user;
		
	}
	
	@PostMapping("/post.do")
	public void postTest(@RequestBody(required = false) User user) {
		
		user.setName("권율");
		user.setEmail("kwonyul@gmail.com");
		
		userRepository.save(user);
		System.out.println("/post.do 값");
		userRepository.findAll().forEach(System.out::println);
	}
	
}
