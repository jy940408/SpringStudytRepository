package com.jwttutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
// 기본적인 web 보안을 활성화하겠다는 의미
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//h2-console 하위 모든 요청들과 파비콘 관련 요청은 Spring Security 로직을 수행하지 않도록 configure 메소드 오버라이드해 내용 추가
	@Override
	public void configure(WebSecurity web){
		web
			.ignoring()
			.antMatchers("/h2-console/**" // /h2-console 하위 모든 요청
						,"/favicon.ico" // 파비콘 요청
			);
//			/h2-console/ 하위 모든 요청과 파비콘 요청은 모두 무시하는 것으로 설정
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
//			HttpServletRequest를 이용하는 요청들에 대한 접근 제한을 설정하겠다는 의미
			.antMatchers("/api/hello").permitAll()
//			"/api/hello"에 대한 요청은 인증없이 접근을 허용하겠다
			.anyRequest().authenticated();
//			나머지 요청들에 대해서는 모두 인증되어야 한다
	}
	
}
