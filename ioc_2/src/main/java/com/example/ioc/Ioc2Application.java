package com.example.ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Ioc2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ioc2Application.class, args);
		
		ApplicationContext context = ApplicationContextProvider.getContext();
//		bean을 가져오는 방법은 여러가지가 있는데, 이름을 통해서 가져오는 방법이 있고, 클래스 타입을 가지고 찾아올 수 있음
		
		Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
		UrlEncoder urlEncoder = context.getBean(UrlEncoder.class);
		
		Encoder encoder = new Encoder(base64Encoder);
		
		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
		
		String result = encoder.encode(url);
		
		System.out.println(result);
		
		encoder.setIEncoder(urlEncoder);
		result = encoder.encode(url);
		
		System.out.println(result);
		
	}

}

@Configuration //하나의 클래스에서 여러개의 bean을 등록할 것이라는 뜻
class Appconfig{
	
	@Bean("base64Ecode")
	public Encoder encoder(Base64Encoder base64Encoder) {
		return new Encoder(base64Encoder);
	}
	
	@Bean("urlEncode")
	public Encoder encoder(UrlEncoder urlEncoder) {
		return new Encoder(urlEncoder);
	}
	
}

