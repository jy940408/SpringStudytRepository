package com.fastcampus.jpa.bookmanager.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class User { 

	@NonNull
	private String name;
	private String email;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt; 
	
}


// getter setter 만드는 법 두가지
// 첫번째로 직접 손으로 쳐서 혹은 단축키를 써서 작성해주기
// 두번째로 lombok 사용하기
// 클래스 위에 @Getter, @Setter 어노테이션 추가를 해주면 모든 필드에 대하여 getter, setter 사용 가능
// 필드에서 하면 해당 getter, setter만 생성해줌