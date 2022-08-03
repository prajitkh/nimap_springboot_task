package com.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.entity.LoggerEntity;
@Repository
public interface LoggerRepository  extends JpaRepository<LoggerEntity, Long>{
	
	void  removeByToken(String token);
	
	LoggerEntity findByToken(String token);

	
	

}
