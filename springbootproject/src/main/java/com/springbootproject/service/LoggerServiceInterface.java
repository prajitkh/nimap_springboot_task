package com.springbootproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootproject.dto.LoggerDto;
import com.springbootproject.entity.LoggerEntity;
import com.springbootproject.entity.User;

@Service
public interface LoggerServiceInterface {


	void createLogger(LoggerDto loggerDto, User user);
	void logout(String token);
	
 //  LoggerEntity getLoggerDetail(String token);
}
