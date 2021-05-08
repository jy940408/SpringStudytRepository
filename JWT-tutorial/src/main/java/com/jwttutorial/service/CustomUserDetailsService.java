package com.jwttutorial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jwttutorial.entity.User;
import com.jwttutorial.repository.UserRepository;

// Spring Security에서 중요한 부분 중 하나인 UserDetailService를 커스텀 구현한 클래스
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
//	UserDetailsService를 implements
	private final UserRepository userRepository;
//	implements한 뒤, UserRepository를 주입받음
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	@Transactional
//	loadUserByUsername 메소드를 오버라이드
	public UserDetails loadUserByUsername(final String username) {
		
		return userRepository.findOneWithAuthoritiesByUsername(username)
				.map(user -> createUser(username, user))
				.orElseThrow(() -> new UsernameNotFoundException(username + " -> 데이터베이스에서 찾을 수 없습니다."));
		
//		로그인 시에 DB에서 유저 정보와 권한 정보를 가져오게 됨.
		
	}
	
	private org.springframework.security.core.userdetails.User createUser(String username, User user){
		if(!user.isActivated()) {
			throw new RuntimeException(username + " -> 활성화되어 있지 않습니다.");
		}
		List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
				.map(authority -> new SimpleGrantedAuthority(authority.getAuthorityName()))
				.collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), 
				user.getPassword(), 
				grantedAuthorities);

//		위에서 가져온 정보를 기반으로 userdetails.User 객체를 생성해서 리턴
		
	}
}
