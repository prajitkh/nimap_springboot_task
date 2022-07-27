
package com.springbootproject.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.springbootproject.dto.SuccessResponseDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.exceptions.ErrorResponseDto;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userService;

//
//	@GetMapping("")
//	public ResponseEntity<?> getAlluser(
//			@RequestParam(defaultValue = "")String search,
//			@RequestParam(defaultValue = "1")String pagNo,
//			@RequestParam(defaultValue = "10")String size)
//	{
//
//		Page<UserDto> user=userService.getAllUser(search, pagNo, size);
//
//
//		if(user.getTotalElements() !=0) {
//
//			return new ResponseEntity<>(new SuccessResponseDto("sucess", "Sucess",  user.getContent()),HttpStatus.OK);
//		}
//		else
//		{
//			return new ResponseEntity<>(new ErrorResponseDto("faild","tryAgain"),HttpStatus.BAD_REQUEST);
//
//		}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllUser(){
	List<UserDto> user=this.userService.getAllUser();
	try {
		return new ResponseEntity<>(new SuccessResponseDto("Sucess","Sucess", user),HttpStatus.OK);
		
	}catch(ResourceNotFoundException e) 
	{
		return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"USER NOT FOUND"),HttpStatus.BAD_REQUEST);

	}
	}
	@PostMapping("/")
	public ResponseEntity<?>createUser( @RequestBody UserDto userDto)
	{
		try {
			UserDto createUserDto=this.userService.creatUser(userDto);
			return new ResponseEntity<>(new SuccessResponseDto("Success","Success", createUserDto),HttpStatus.OK);
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"User Already Exist"),HttpStatus.NOT_FOUND);

		}


	}

	//get user by id
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Integer userId)
	{
		try {

			UserDto userDto=this.userService.getUserById(userId);
			return new ResponseEntity<>(new SuccessResponseDto("Success","Success", userDto),HttpStatus.OK);
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"User Not Found"),HttpStatus.NOT_FOUND);
		}
	}
	//update user 
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto,@PathVariable("id")int uid )
	{

		try {
			UserDto updateUser=this.userService.updateUser(userDto, uid);
			return new  ResponseEntity<>(new SuccessResponseDto("Success","Success", updateUser),HttpStatus.OK);
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"User Not Found"),HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Integer id){

		try {
			this.userService.deleteUser(id);
			return new  ResponseEntity<>(new SuccessResponseDto("Success","Success", "Deleted Ok.!"),HttpStatus.OK);
		}catch(ResourceNotFoundException e) {

			return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"User Not Found"),HttpStatus.NOT_FOUND);



		}
	}
}










