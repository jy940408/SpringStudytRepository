package com.jwttutorial.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jwttutorial.dto.TokenDto;
import com.jwttutorial.dto.UserDto;
import com.jwttutorial.jwt.JwtFilter;

@Controller
@RequestMapping("/api")
public class HelloController {

	public static final String AUTHORIZATION_HEADER = "Authrization";
	
	@GetMapping(path = "/hello") 
	public String hello(){
		return "Login";
	}
	
	@GetMapping(path = "/hi")
	public String hi(HttpServletRequest request) {
		//헤더에 AUTHORIZATION_HEADER(=Authrization)값을 키값으로 갖는 value값을 bearerToken 변수에 담는다
		String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
		String token = null;
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
			
			token = bearerToken.substring(7);
			
		}
		
		System.out.println("test: " + token);
		
		
		return "test";
	}
	
}
