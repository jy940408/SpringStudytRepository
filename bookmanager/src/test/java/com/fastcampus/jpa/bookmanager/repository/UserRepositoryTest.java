package com.fastcampus.jpa.bookmanager.repository;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.fastcampus.jpa.bookmanager.domain.User;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	void crud() {
		List<User> users_1 = userRepository.findAll(Sort.by(Direction.DESC, "name"));
		users_1.forEach(System.out::println);
		
		List<User> users_2 = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
		users_2.forEach(System.out::println);
		
		User user1 = new User("jack", "jack@fastcampus.com");
		User user2 = new User("steve", "steve@fastcampus.com");
		
		userRepository.saveAll(Lists.newArrayList(user1, user2));
		
		List<User> users_3 = userRepository.findAll();
		users_3.forEach(System.out::println);
	}
	
}
