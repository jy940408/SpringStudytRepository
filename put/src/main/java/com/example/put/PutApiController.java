package com.example.put;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.put.dto.PostRequestDto;

@RestController
@RequestMapping("/api")
public class PutApiController {

	@PutMapping("/put")
	public PostRequestDto put(@RequestBody PostRequestDto requestDto) {
		
		System.out.println(requestDto);
		
		return requestDto;
	}
	
	@PutMapping("/put/path/{userId}")
	public PostRequestDto path(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") long id) {
		
		System.out.println(id);
		System.out.println(requestDto);
		return requestDto;
	}
}
