package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //해당Class는 Rest API 처리하는 controller라는 뜻
@RequestMapping("/api") //RequestMapping URI를 지정해주는 Annotation
public class ApiController {
	
	@GetMapping("/hello") // http://localhost:9090/api/hello라는 곳으로 맵핑이 된 
	public String hello() {
		return "hello spring boot!";
	}
	
}
