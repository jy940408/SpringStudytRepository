package com.company.ioc;

public class Main {

	public static void main(String[] args) {
		
		String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
		
		//Base 64로 인코딩 하기
		Base64Encoder encoder = new Base64Encoder();
		String result = encoder.encode(url);		
		System.out.println(result);

		// url 인코딩
		UrlEncoder urlEncoder = new UrlEncoder();
		String urlResult = urlEncoder.encode(url);
		System.out.println(urlResult);
		
//		이런 방식으로 인코딩이 나올 때마다 인코더를 만들어서 사용할 수 있음
//		앞으로 계속 인코딩 하는 상황이 나온다면? 물론 아무 생각없이 하면 이렇게 계속 인코더를 만들어서 사용할 수 있음

//		이제 우리는 이것을 분리할 것임, 추상을 적용하는 것
		
//		수정된 방법으로 적용해보기
		
		Encoder encoder_ = new Encoder(new Base64Encoder());
		String eResult = encoder_.encode(url);
		System.out.println(eResult);
		
		
	}

}
