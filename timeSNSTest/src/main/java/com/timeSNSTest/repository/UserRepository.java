package com.timeSNSTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.timeSNSTest.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
