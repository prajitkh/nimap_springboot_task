package com.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.entity.User;

public interface AuthRepository  extends JpaRepository<User ,Integer>{
	User findByEmail(String email);
}
