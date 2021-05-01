package com.example.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {

	private String account;
	private String email;
	private String address;
	private String password;
	
	@JsonProperty("phone_number")
//	@JasonProperty는 다른 이름으로 Json 키값을 받았을 때 연결해주는 기능을 하는 것
//	즉, 이 경우에는 phone_number로 넘어온 값도 phoneNumber에 넣어준다
	private String phoneNumber;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "PostRequestDto [account=" + account + ", email=" + email + ", address=" + address + ", password="
				+ password + ", phoneNumber=" + phoneNumber + "]";
	}
	
}
