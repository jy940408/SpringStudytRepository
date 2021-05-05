package com.fastcampus.jpa.bookmanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fastcampus.jpa.bookmanager.domain.User;

@SpringBootTest
public class SimpleJpaRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void crud() {
		
		userRepository.save(new User("david", "david@fastcampus.com"));
		
		User user = userRepository.findById(1L).orElseThrow(null);
		user.setEmail("martin-updated@fastcampus.com");
		
		userRepository.save(user);
		userRepository.findAll().forEach(System.out::println);
	}
	
}
