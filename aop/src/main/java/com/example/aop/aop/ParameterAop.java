package com.example.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect			//AOP로 동작하기 위해 선언하는 어노테이션
@Component		//당연히 Spring에서 관리되어야 하기 때문에 선언해야하는 어노테이
public class ParameterAop {

	@Pointcut("execution(* com.example.aop.controller..*.*(..))")
//	우리는 com.example.aop 안의 controller라는 패키지 하위에 있는 모든 메소드를 다 aop로 보겠다는 설정을 뜻하는 것
//	이건 사용할 때 검색해보면서 해야 함
//	보통은 특정 클래스, 특정 패키지 하위에 있는 것들을 확인해보기 때문에 비슷하게 사용함
	private void cut() {
//		우리는 메소드가 들어가기 전에 어떤 값이 들어갔는지 확인하고, 그게 들어가고 나서 어떤 값이 return되는지 확인해볼 것
	}
	
	@Before("cut()") // -> cut() 메소드가 실행되는 지점에서 시행된다는 뜻
//	언제 실행시킬 것이냐에 관한 어노테이션
	public void before(JoinPoint joinPoint) {
//		JoinPoint라고 들어가는 지점에 대한 정보를 넣어줄 수 있는 객체를 넣어줌
		
		Object[] args = joinPoint.getArgs();
		//joinPoint.getArgs()는 메소드에 들어가고 있는 매개변수들의 배열을 받아옴
		
		for(Object obj : args) {
			System.out.println("type: " + obj.getClass().getSimpleName());
			System.out.println("value: " + obj);
		}
		
	}
	
	@AfterReturning(value = "cut()", returning = "returnObj") // -> cut() 메소드가 끝나는 지점에서 시행된다는 뜻
	public void afterReturn(JoinPoint joinPoint, Object returnObj) {
//		AfterReturning에는 object를 받을 수 있음
//		annotation 부분에 들어가는 returning과 메소드에 들어가는 object의 변수 명이 같아야 함
		
		System.out.println("return obj");
		System.out.println(returnObj);
		
	}
	
//	해당 메소드 설정을 끝내고 어떤 파라미터가 들어가고 어떤 파라미터가 리턴 되는지 확인해보면 됨
	
}
