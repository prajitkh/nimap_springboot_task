package com.springbootproject.service;


import org.springframework.stereotype.Service;

import com.springbootproject.entity.LoggerEntity;

@Service
public interface ApiLoggerInterface {
	
	
	void createApilog(String token);

}
