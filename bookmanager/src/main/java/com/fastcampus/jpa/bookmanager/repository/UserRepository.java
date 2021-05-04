package com.fastcampus.jpa.bookmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fastcampus.jpa.bookmanager.domain.User;

														//첫번째 값은 엔티티, 두번째 값은 엔티티의 pk의 타입
public interface UserRepository extends JpaRepository<User, Long>{
}

// 바로 이 영역이 Spring Data JPA 라이브러리가 지원해주는 영역
// 인터페이스를 선언해주고 JpaRepositody를 상속받는 것만으로도 많은 jpa관련 메소드를 지원해주고 있음
