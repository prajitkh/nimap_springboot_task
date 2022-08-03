package com.springbootproject.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.LoggerDto;
import com.springbootproject.entity.LoggerEntity;
import com.springbootproject.entity.User;
import com.springbootproject.repository.LoggerRepository;
import com.springbootproject.service.LoggerServiceInterface;
@Service("LoggerServiceImpl")
public class LoggerServiceImpl  implements LoggerServiceInterface{

	
	@Autowired
	private LoggerRepository loggerRepository;
	
	@Override
	public void createLogger(LoggerDto loggerDto, User user) {
	LoggerEntity logger=new LoggerEntity();
	//logger.setId(user);
	logger.setToken(loggerDto.getToken());
	logger.setExpireAt(loggerDto.getExpireAt());
	loggerRepository.save(logger);
		
	}

	@Override
	public void logout(String token) {
		final String token1=token.substring(7);
	
		loggerRepository.removeByToken(token1);
		
		
	}

	@Override
	public LoggerEntity getLoggerDetail(String requestTokenHeader) {
	
		return this.loggerRepository.findByToken(requestTokenHeader);
	}

}
	


