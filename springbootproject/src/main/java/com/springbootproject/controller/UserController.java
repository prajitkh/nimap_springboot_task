package com.springbootproject.controller;


import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;


	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAlluser(@RequestParam(value = "pageNumber",defaultValue = "1",required = false)Integer pageNumber,@RequestParam(value = "pageSize",defaultValue = "5",required = false)Integer pageSize)
	{
		List<UserDto> user= this.userService.getAllUser(pageSize, pageSize);
		return new ResponseEntity<List<UserDto>>(user,HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<UserDto>createUser( @RequestBody UserDto userDto)
	{
		UserDto createUserDto=this.userService.creatUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.FOUND);
	}

	//get user by id

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId)
	{
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	//update user 
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("id")int uid )
	{
		UserDto updateUser=this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updateUser);
	}

	//	//@RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
	//	@DeleteMapping("userId")
	//	public User deleteUser(@RequestBody User user,@PathVariable("userId")Integer id)
	//	{
	//		////return this.userService.deleteUser(id);
	//
	//	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id){
		this.userService.deleteUser(id);

	}
}










