package com.example.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

//	controller 하위의 모든 것들에 조건을 건 것
	@Pointcut("execution(* com.example.aop.controller..*.*(..))")
	private void cut() {}
	
//	annotation 패키지 하위의 Timer annotation이라는 조건을 건 것
	@Pointcut("@annotation(com.example.aop.annotation.Timer)")
	private void enableTimer() {}
	
//	Timer는 시간을 재는 것이기 때문에 전,후가 필요함.
//	그런데 이것은 @Before과 @AfterReturning으로 설정할 수 없음
//	이럴 때 사용하는 것이 @Around
	
	@Around("cut() && enableTimer()")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
//		joinPoint의 proceed를 호출하면 메소드가 실행되는 것.
//		proceed가 호출되고 return되는게 있다면 Object 타입으로 return
//		joinPoint.proceed()를 기준으로 위 아래가 전과 후가 됨
//		joinPoint.proceed()가 실행되어야 하는 메소드기 때문에 위에는 실행되기 전, 아래는 실행된 후
		Object result = joinPoint.proceed();
		
		stopWatch.stop();
		
		System.out.println("total time: " + stopWatch.getTotalTimeSeconds());
		
		
	}
}
