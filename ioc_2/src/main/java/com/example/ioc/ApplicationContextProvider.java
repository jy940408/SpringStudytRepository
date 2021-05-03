package com.example.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component // 그리고 얘도 스프링에서 관리해줘 하고 선언
public class ApplicationContextProvider implements ApplicationContextAware{ //ApplicationContextAware라는 클래스를 상속받
	
	private static ApplicationContext context;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
										//이것도 주입을 받는데 어디서? 스프링이 주입해줌
//		여기서 주입이 일어나면 applicationContext를 할당해주겠다
		context = applicationContext;
//		그리고 이걸 받아서 static 변수에 할당해주겠다
//		그럼 이제 이걸 가져다 쓰기만 하면 됨
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	
	
}
