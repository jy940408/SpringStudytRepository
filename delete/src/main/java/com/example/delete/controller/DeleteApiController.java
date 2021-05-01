package com.example.delete.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

	@DeleteMapping("/delete/{userId}")
	public void delete(@PathVariable String  userId, @RequestParam String account) {
		
		System.out.println(userId);
		System.out.println(account);
		
//		delete의 경우 get과 동일함
//		대신 하는 동작 자체가 리소스를 삭제하는 것
//		그렇다고 값이 없을 때, 없다고 오류를 내지 않음
//		delete 자체가 리소스의 삭제임
//		이미 리소스가 없는 상태더라도 에러를 뜨게 하는게 아니라 그냥 200 ok 결과를 냄
//		지금 삭제해서 값이 없는 것이든, 이미 없는 것이든 어쨌든 결과는 똑같기 때문
	}
	
}
