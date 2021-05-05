package com.fastcampus.jpa.bookmanager.repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		
		userRepository.save(new User("new martin", "newmartin@fastcampus.com"));
		userRepository.flush();
		userRepository.findAll().forEach(System.out::println);
		
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIgnorePaths("name")
				.withMatcher("email", endsWith());
		
		Example<User> example = Example.of(new User("ma", "fastcampus.com"), matcher);
		
		userRepository.findAll(example).forEach(System.out::println);
		
		Page<User> users_4 = userRepository.findAll(PageRequest.of(1,3));
																// 페이지 인덱스(즉,0부터 시작함), 페이지 사이즈
		
		System.out.println("page: " + users_4);
		System.out.println("totalElements: " + users_4.getTotalElements()); //페이지가 나눠지는 데이터의 수
		System.out.println("totalPages: " + users_4.getTotalPages()); // 페이지 갯수, 8개의 데이터가 3개를 기준으로 나눠지니 3페이지까지 나옴
		System.out.println("numberOfElements: " + users_4.getNumberOfElements()); // 현재 페이지에 출력되는 데이터의 갯수
		System.out.println("sort: " + users_4.getSort()); // 적용하지 않았기에 따로 안나옴
		System.out.println("size: " + users_4.getSize()); // 페이지 사이즈
		
		users_4.getContent().forEach(System.out::println);
		
		long count = userRepository.count();
		System.out.println("count: " + count);
		
		boolean exists = userRepository.existsById(1L);
		System.out.println("boolean: " + exists);
		
		userRepository.deleteById(1L);
		userRepository.findAll().forEach(System.out::println);
		
		userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(2L,3L)));
		userRepository.findAll().forEach(System.out::println);
		
		userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(4L,5L)));
		userRepository.findAll().forEach(System.out::println);
		
		userRepository.deleteAllInBatch();
		userRepository.findAll().forEach(System.out::println);
		
		userRepository.deleteAll();
		userRepository.findAll().forEach(System.out::println);
	}
	
}
