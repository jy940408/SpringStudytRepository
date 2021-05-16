package com.jwttutorial.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwttutorial.dto.UserDto;
import com.jwttutorial.entity.User;
import com.jwttutorial.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

		private final UserService userService;
	
		public UserController(UserService userService) {
			this.userService = userService;
		}
	
//		UserDto를 파라미터로 받아서 UserService의 signup 메소드를 호출
		@PostMapping("/signup")
		public ResponseEntity<User> signup(@Valid @RequestBody UserDto userDto){
			System.out.println(userDto);
			return ResponseEntity.ok(userService.signup(userDto));
		}
		
//		@PreAuthorize 어노테이션을 통해 'USER', 'ADMIN' 두가지 권한 모두 허용
		@GetMapping("/user")
		@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
		public ResponseEntity<User> getMyUserInfo(){
			return ResponseEntity.ok(userService.getMyUserWithAuthorities().get());
		}
		
//		'ADMIN' 권한만 호출할 수 있도록 설정
//		UserService에서 만들었던 username 파라미터를 기준으로 유저 정보와 권한 정보를 리턴하는 API임
		@GetMapping("/user/{username}")
		@PreAuthorize("hasAnyRole('ADMIN')")
		public ResponseEntity<User> getUserInfo(@PathVariable String username){
			return ResponseEntity.ok(userService.getUserWithAuthorities(username).get());
		}
}
