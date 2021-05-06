package com.timeSNSTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timeSNSTest.domain.User;
import com.timeSNSTest.repository.UserRepository;

@RestController
@RequestMapping("/timep")
public class PostTestController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/post.do")
	public void postTest(@RequestBody User user) {
		
		user.setName("권율");
		user.setEmail("kwonyul@gmail.com");
		
		userRepository.save(user);
		System.out.println("/post.do 값");
		userRepository.findAll().forEach(System.out::println);
		
	}
	
	@PostMapping("/post2.do")
	public void postTest2() {
		
		User user = new User();
		
		user.setName("박철진");
		user.setEmail("cheoljin@gmail.com");
		
		userRepository.save(user);
		System.out.println("/post2.do 값");
		userRepository.findAll().forEach(System.out::println);
		
	}
	
	@GetMapping("/list.do")
	public List<User> posttoget() {
		
		List<User> user = userRepository.findAll();
		
		System.out.println("/list.do 값");
		user.forEach(System.out::println);
		
		return user;
	}
	
}
