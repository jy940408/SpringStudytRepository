package com.jwttutorial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jwttutorial.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	@EntityGraph(attributePaths = "authorities")
//	@EntityGraph는 쿼리가 수행이 될 때, Lazy	조회가 아니고, Eager조회로 authorities정보를 같이 가져오게 됨
	Optional<User> findOneWithAuthoritiesByUsername(String username);
//	findOneWithAuthoritiesByUsername은 username을 기준으로 User 정보를 가져올 때, 권한 정보도 같이 하져오게 됨
	
}
