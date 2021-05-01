package com.example.post.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post.dto.PostRequestDto;

@RestController
@RequestMapping("/api")
public class PostApiController {

	@PostMapping("/post")
//	get방식일 때에는 @RequestParam을 붙였지만, post방식일 때에는 @RequestBody를 붙여줘야 
	public void post(@RequestBody Map<String, Object> requestData) {
		
		requestData.forEach((key, value) -> {
			
			System.out.println("key: " + key);
			System.out.println("value: " + value);
			
		});
		
	}
	
	@PostMapping("/post/dto")
//	get방식에서 dto를 받아올 때에는 @RequestParam을 안적었는데, post방식에서는 @RequestBody를 적어줌
	public void postDto(@RequestBody PostRequestDto requestData) {
		
		System.out.println(requestData);
		
	}
	
}
