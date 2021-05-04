package com.example.validation.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

	private String name;
	private int age;
	@Email
	private String email;
	@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 양식과 맞지 않습니다 ") //정규식을 사용하는 annotation
	private String phoneNumber;
	
	@Size(min = 6, max = 6)
	private String reqYearMonth; //yyyyMM
	
	@AssertTrue
	public boolean reqYearMonthValidation() {
		
		this.reqYearMonth = getReqYearMonth() + "01";
		
		try {
			LocalDate localDate = LocalDate.parse(this.reqYearMonth, DateTimeFormatter.ofPattern("yyyyMM"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getReqYearMonth() {
		return reqYearMonth;
	}
	public void setReqYearMonth(String reqYearMonth) {
		this.reqYearMonth = reqYearMonth;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", reqYearMonth=" + reqYearMonth + "]";
	}
	
}
