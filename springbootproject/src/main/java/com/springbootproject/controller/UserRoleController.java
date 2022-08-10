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
import com.springbootproject.dto.SuccessResponseDto;
import com.springbootproject.entity.AssignRole;
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

	@PostMapping("/role")
	public ResponseEntity<?> editUser(@RequestBody AssignRole assignRole ){
		try
		{
			this.userRoleService.editUserRole(assignRole);

			return new ResponseEntity<>(new SuccessResponseDto(),HttpStatus.FOUND);
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"Role Not Found"),HttpStatus.NOT_FOUND);
		}
	}



	//@PutMapping("/{uid}")
	//public ResponseEntity<?> editUser(@RequestBody List<Integer> roleIds,@PathVariable int uid) {
	//
	//User user =this.userService.userToRole(roleIds, uid);
	//
	//return new ResponseEntity<>(user,HttpStatus.OK);	
	//
	//}


@GetMapping("/")
public List<UserRoleEntity> getAllUserRoles(@RequestBody UserRoleEntity userRoleEntity ){
	List<UserRoleEntity> roleEntity=this.userRoleService.getAllUserRole(userRoleEntity);
	return roleEntity;

	
}

}





