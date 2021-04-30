package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

	//path를 붙이지 않아도 자동적으로 주소가 path 설정 되는데, 명시적으로 path = "/hello"와 같이 표현해줄 수도 있
	@GetMapping(path = "/hello") // http://localhost:8090/api/get/hello
	public String hello() {
		return "get Hello";
	}
	//당연하게도 post 맵핑도 존재
	
	
//	@RequestMapping("/hi") // get도 동작하고 put도 동작하고 모든 메소드가 다 동작하게 됨, 그래서 메소드를 따로 지정해줘야함
	@RequestMapping(path = "/hi", method = RequestMethod.GET) // get만 지정되고, 주소는 http://localhost:8090/api/get/hi가 됨, 이건 옛날에 쓰던 방식
	public String hi() {
		return "get hi";
	}
	
}
