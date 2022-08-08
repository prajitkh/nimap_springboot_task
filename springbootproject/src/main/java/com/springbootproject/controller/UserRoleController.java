package com.springbootproject.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.springbootproject.dto.EditUserRequestDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.AssignRole;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.User;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.service.RoleService;
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
	private RoleReporsitory roleReporsitory;
	

	//@PutMapping("/{id}")
	//public ResponseEntity<?> editUserAndRole(@PathVariable(value = "id") Integer userId,
	//		@RequestBody EditUserRequestDto userBody, HttpServletRequest request) {
	//	
	//	this.userRepo.findById(userId).orElseThrow();
	//	
	//	this.userService.editUserRole(userBody, userId);
	//			return null;
	//		
	//	}
	//		


	@PutMapping("/{id}")
	public ResponseEntity<?> editUserAndRole(@PathVariable(value = "id") Integer userId,
			@RequestBody UserDto requestDto, HttpServletRequest request)
	{

		try {
			User user =this.userRepo.findById(userId).orElseThrow();

			userService.editUserRole(userId, requestDto);
			return new ResponseEntity<>(user,HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}
	
	
	
//	@PutMapping("/{id}")
//	public User editUserToUser(@RequestBody RoleEntity roleId,@PathVariable int id)
//	{
//		return this.userService.addUserRole(roleId, id);
//	
//		
//	}
//	@PostMapping("/")
//	public ResponseEntity<?> assignRole( @RequestBody AssignRole assignRole) {

//		int uid=assignRole.getUserId();
//		int rid=assignRole.getRoleId();
		
		//this.userService.addRoleToCandidate(uid, rid);
		
		
//		String roleName=assignRole.getRoleName();
//		System.out.println("*********"+assignRole.getRoleName());
//		String userEmail=assignRole.getEmail();
//		userService.addRoleToCandidate(roleName, userEmail);
//	
//		return new ResponseEntity<>(HttpStatus.CREATED);
//		
//}
	
//	  @PostMapping("/{id}")
//	  public RoleEntity createComment(@PathVariable(value = "id") int id,
//	      @RequestBody RoleEntity roleEntity) {
//	    Stream<Object> entity = userRepo.findById(id).stream().map( e -> roleEntity.getUser() );
//	    return  roleReporsitory.save(roleEntity);
//	    
//	
//	  }

		
	}
