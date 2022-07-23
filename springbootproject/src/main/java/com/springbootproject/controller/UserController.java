package com.springbootproject.controller;


import java.util.List;
import java.util.Map;

import org.hibernate.engine.spi.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.dto.UserDto;

import com.springbootproject.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/")

	public List<UserDto> getAlluser(){
		
		return this.userService.getAllUser();

	}

@PostMapping("/")
public ResponseEntity<UserDto>createUser(@RequestBody UserDto userDto){
	UserDto createUserDto=this.userService.creatUser(userDto);
	return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	
}

//get user by id

@GetMapping("/{userId}")
public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){

	return ResponseEntity.ok(this.userService.getUserById(userId));

}
//update user 
@PutMapping("/{id}")
public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("id")int uid ){
	
	UserDto updateUser=this.userService.updateUser(userDto, uid);
	return ResponseEntity.ok(updateUser);
	
	
}

@DeleteMapping("/userId")
public  void deleteUser(@PathVariable("userId")Integer id)
{
this.userService.deleteUser(id);

	
	
	
	
	}

}










