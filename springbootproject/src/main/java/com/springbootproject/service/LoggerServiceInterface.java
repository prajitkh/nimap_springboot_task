package com.springbootproject.service;

import org.springframework.stereotype.Service;

import com.springbootproject.dto.LoggerDto;
import com.springbootproject.entity.User;

@Service
public interface LoggerServiceInterface {
	
	
 void createLogger(LoggerDto loggerDto, User user);

 
 void logout(String token);
}
