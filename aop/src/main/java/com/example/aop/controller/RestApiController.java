package com.example.aop.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aop.annotation.Timer;
import com.example.aop.dto.User;

@RestController
@RequestMapping("/api")
public class RestApiController {

	
	@GetMapping("/get/{id}")
	public String get(@PathVariable long id, @RequestParam String name) {
//		현재 메소드마다 받아오는 값들을 다 찍었음
//		지금은 메소드가 몇개 되지 않고 받아오는 값도 몇개 되지 않지만 실무에서는 훨씬 더 많은 값들을 자주 받아옴
//		각 메소드마다 로그를 찍는 것을 한 곳으로 모아올 수 있음
//		이제 여기서부터 aop가 시작됨 
		
		System.out.println("get method");
		System.out.println("get method: " + id);
		System.out.println("get method: " + name);
		
		return id + " " + name;
		
	}
	
	@PostMapping("/post")
	public User post(@RequestBody User user) {
		
		System.out.println("post method: " + user);
		
		return user;
	}
	
	@Timer
	@DeleteMapping("/delete")
	public void delete() throws InterruptedException {
		
		Thread.sleep(1000*2);
		
		// 2초 후에 종료되도록 만든 것
		
	}
	
}
