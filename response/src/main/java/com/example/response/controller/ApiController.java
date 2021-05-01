package com.example.response.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.response.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	//text의 경우
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		
		return account;
		
	}
	
	//json의 경우
	//request가 오면 objectMapper라는 애를 통해서 object로 변경되고 메소드를 타게 됨
	//이 메소드를 타고 object를 던지면 얘가 다시 objectMapper라는 애를 통해서 json으로 바뀌고 response가 됨
	@PostMapping("/json")
	public User json(@RequestBody User user){
		
		return user; //200 ok
		
	}

	//ResponseEntity
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user) {
		
//		우리가 response를 내려줄 때, http status를 정해줄 것임
//		그러기 위해 우리가 내려주는 방법이 바로 ResponseEntity, 이 객체를 통해서 내려줘야 함
//		ResponseEntity에 제네릭 타입을 정해주면 됨
//		응답을 내릴 때 ResponseEntity의 ok라는 것에 body를 넣어줄 수 있고, status를 이용해서 status를 지정해줄 수 있음
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
//		위의 return을 설명해보자면
//		ResponseEntity에다가 명확하게 HttpStatus 코드를 지정해주고, 그리고 body에 데이터를 집어넣은 것
//		이 외의 헤더값도 추가하는 등 ResponseEntity를 통해 여러가지 설정을 해줄 수 있음
		
		
		
	}
}
