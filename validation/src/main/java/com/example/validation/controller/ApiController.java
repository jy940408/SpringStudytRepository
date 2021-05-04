package com.example.validation.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validation.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {

	@PostMapping("/user")							//BingdingResult를 받으면, validation에 오류가 났을 때, 오류 내용이 해당 변수에 들어감
	public User user(@Valid @RequestBody User user, BindingResult bindingResult) {
//					받아야 하는 값에 validation을 사용했다면 매개변수 선언 부분에 @Valid annotation을 붙여줘야 사용 가능함
		
		if(bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(objectError -> {
				FieldError field = (FieldError) objectError;
				String message = objectError.getDefaultMessage();
				System.out.println("field: " + field.getField());
				System.out.println(message);
			});
		}
		
		System.out.println(user);
		
		return user;
	}
}
