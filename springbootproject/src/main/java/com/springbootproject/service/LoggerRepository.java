package com.springbootproject.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.entity.LoggerEntity;

public interface LoggerRepository  extends JpaRepository<LoggerEntity, Long>{
	
	void  removeByToken(String token);

}
