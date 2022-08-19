package com.springbootproject.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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


import com.springbootproject.dto.SuccessResponseDto;
import com.springbootproject.dto.UserDataDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.dto.UserRoleDto;
import com.springbootproject.entity.AssignRole;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.User;
import com.springbootproject.entity.UserRoleEntity;
import com.springbootproject.exceptions.ErrorResponseDto;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.repository.UserRepo;

import com.springbootproject.service.RoleService;
import com.springbootproject.service.UserRoleService;
import com.springbootproject.service.UserService;

@RestController
@RequestMapping("/user_role")
public class UserRoleController {

	@Autowired
	RoleService roleService;

	@Autowired
	UserRepo userRepo;

	@Autowired
	UserService userService;
	@Autowired
	UserRoleService userRoleService;

	@Autowired
	RoleReporsitory roleReporsitory;
	@PostMapping("/role")
	public ResponseEntity<?> addUserRole(@RequestBody AssignRole assignRole ) throws Exception
	{
		try {

			this.userRoleService.addUserToRole(assignRole);

			return new ResponseEntity<>(new SuccessResponseDto("add UserToRoles", "check", null),HttpStatus.OK);
		}catch(Exception e) 
		{
			return new ResponseEntity<>("Already.existis userRole",HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/check")
	public ResponseEntity<?> getAllUser(){


		try {

			List<UserRoleEntity> user=this.userRoleService.getAllUserRols1();

			return new ResponseEntity<>(new SuccessResponseDto("Sucess","Sucess", user),HttpStatus.OK);

		}catch(Exception e) 
		{
			return new ResponseEntity<>( new ErrorResponseDto("USER NOT FOUND", "check"),HttpStatus.BAD_REQUEST);
		}
	}




	//	@GetMapping("/{id}")
	//	public ResponseEntity<?> getUserById(@PathVariable(value = "id") Integer userId) throws ResourceNotFoundException {
	//
	//		try {
	//
	//		//	UserDataDto userDetail = this.userRoleService.getUserRole(userId);
	//			System.out.println("ABCD"+userDetail);
	//			return new ResponseEntity<>(new SuccessResponseDto("Success", "success", userDetail), HttpStatus.OK);
	//
	//		} catch (ResourceNotFoundException e) {
	//
	//			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "userNotFound"), HttpStatus.NOT_FOUND);
	//
	//		}



	@DeleteMapping("/")
	public ResponseEntity<?> deleteUserRoles(@RequestBody AssignRole assignRole )
	{
		try {
     this.userRoleService.deleteUserRoles(assignRole);
			return new ResponseEntity<>(new SuccessResponseDto("Delete UserRole Successfully ", "check",null),HttpStatus.OK);
		}catch(Exception e) 
		{
			return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"USER&ROLE NOT FOUND"),HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PutMapping("/update")
	public ResponseEntity< ?>updateUserRoles(@RequestBody AssignRole assignRole )
	{
		try {

			this.userRoleService.updateUserRoles(assignRole);
			return new ResponseEntity<>(new SuccessResponseDto("update UserToRoles", "check", null),HttpStatus.OK);
		}catch(Exception e) 
		{
			return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"USER NOT FOUND"),HttpStatus.BAD_REQUEST);
		}
	}

}












