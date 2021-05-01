package com.example.put.dto;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
// 해당 클래스 전체의 네이밍 규칙을 정해주는 것
// 앞서 @JsonProperty는 하나의 값에만 다른 이름은 연결해줬다면, @JsonNaming은 클래스 전체의 변수들에 다른 이름은 연결해줄 수 있음 
public class PostRequestDto {

	private String name;
	private int age;
	private List<CarDto> carList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<CarDto> getCarList() {
		return carList;
	}
	public void setCarList(List<CarDto> carList) {
		this.carList = carList;
	}
	
	@Override
	public String toString() {
		return "PostRequestDto [name=" + name + ", age=" + age + ", carList=" + carList + "]";
	}
	
}
