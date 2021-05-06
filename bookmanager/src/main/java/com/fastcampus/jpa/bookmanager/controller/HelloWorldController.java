package com.fastcampus.jpa.bookmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/hello-world")
	public String helloWorld(@RequestParam(required = false) String test) {
	
		User user = new User();
		user.setEmail("junyoung940408@gmail.com");
		userRepository.save(user);
		
		System.out.println("이곳입니다 에베베베베베베베 이곳입니다에베베베베베");
		userRepository.findAll().forEach(System.out::println);
		
		System.out.println(test);
		
		return "hello-world";
	}
	
}