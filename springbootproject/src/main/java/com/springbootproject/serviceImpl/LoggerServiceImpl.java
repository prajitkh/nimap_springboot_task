package com.springbootproject.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.LoggerDto;
import com.springbootproject.entity.LoggerEntity;
import com.springbootproject.entity.User;
import com.springbootproject.service.LoggerRepository;
import com.springbootproject.service.LoggerServiceInterface;
@Service
public class LoggerServiceImpl  implements LoggerServiceInterface{

	
	@Autowired
	private LoggerRepository loggerRepository;
	
	@Override
	public void createLogger(LoggerDto loggerDto, User user) {
	LoggerEntity logger=new LoggerEntity();
	logger.setUserId(user);
	logger.setToken(loggerDto.getToken());
	logger.setExpireAt(loggerDto.getExpireAt());
	loggerRepository.save(logger);
		
	}
}


