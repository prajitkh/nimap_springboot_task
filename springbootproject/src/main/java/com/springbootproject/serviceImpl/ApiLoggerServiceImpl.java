package com.springbootproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.entity.LoggerEntity;
import com.springbootproject.repository.ApiLoggerRepository;
import com.springbootproject.repository.LoggerRepository;
import com.springbootproject.service.ApiLoggerInterface;
@Service
public class ApiLoggerServiceImpl  implements ApiLoggerInterface{

	@Autowired
private LoggerRepository  loggerRepository;
	
	
	@Override
	public void createApilog(String token) {
	
		this.loggerRepository.findByToken(token);
		
	}
}
