package com.example.response.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.response.dto.User;

@Controller
public class PageController {

	
	@RequestMapping("/main")
	public String main() {
		
		return "main.html";
//		@Controller라는 어노테이션은 String을 리턴하면 리소스를 찾게 됨
	}
	
	//ResponseEntity
	
	@ResponseBody
	@GetMapping("/user")
	public User user() {
		
//		하지만 여기에 @ResponseBody라는 어노테이션을 붙여주면 객체 자체를 리턴했을 때, 리소스를 찾지 않고 ResponseBody를 만들어서 내리겠다는 뜻
		
		var user = new User();
		user.setName("steve");
		user.setAddress("패스트 캠퍼스");
		
		return user;
		
	}
	
}
