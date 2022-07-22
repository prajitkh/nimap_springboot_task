package com.springbootproject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;


	///create User
	@PostMapping("/")
	public ResponseEntity<?> createUser( @RequestBody  UserDto userDto)
	{
		this.userService.creatUser(userDto);
		return null;
	}

	@GetMapping("/")
	public List<UserDto> getAlluser(){
		return this.userService.getAllUser();

	}
}











