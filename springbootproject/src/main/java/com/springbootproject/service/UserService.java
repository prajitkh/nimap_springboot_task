package com.springbootproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
@Service
public interface UserService {
	
UserDto  creatUser(UserDto user);

public 	List<UserDto> getAllUser();


		
}


