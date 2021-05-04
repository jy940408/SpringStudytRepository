package com.fastcampus.jpa.bookmanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastcampus.jpa.bookmanager.domain.User;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void crud() {
		userRepository.save(new User());
		userRepository.findAll().forEach(System.out::println);
	}
	
}
