package com.example.hello.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserRequest;

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
	
	
//	http://localhost:8090/api/get/path-variable/{name}
//	상단 클래스가 /api/get까지 가지고 있기 때문에 이 부분은 고정
	@GetMapping("/path-variable/{name}")
	public String pathVariable(@PathVariable String name) {
		System.out.println("PathVariable: " + name);
//		맵핑 주소 끝 {} 내에 들어가는 변수와 @PathVariable 뒤에 설정해주는 변수 이름이 똑같아야 함
//		그런데 하다보면 변수를 여러개 받아야 하는 경우가 생김, 이런 때에는 어떻게 해줘야 할까?
//		@PathVariable(name = "name") String pathName, String name
//		이렇게 설정 해주면, pathName을 name으로 인식함
		
		return name;
	}
	
//	http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
	@GetMapping(path = "/query-param")
	public String queryParam(@RequestParam Map<String, String> queryParam) {
		
		StringBuilder sb = new StringBuilder();
		
		queryParam.entrySet().forEach(entry -> {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			System.out.println("\n");
			
			sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	@GetMapping("/query-param02")
	public String queryParam02(@RequestParam String name, @RequestParam String email, @RequestParam int age) {
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(age);
		
		return name + " " + email + " " + age;
		
	}
	
	@GetMapping("/query-param03")
	public String queryParam03(UserRequest userRequest) {
		
		System.out.println(userRequest.getName());
		System.out.println(userRequest.getEmail());
		System.out.println(userRequest.getAge());
		
		return userRequest.toString();
		
	}
	
	
	
}
