package com.springbootproject.controller;


import java.util.List;

import javax.validation.Valid;
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
import com.springbootproject.dto.RoleDto;
import com.springbootproject.dto.SuccessResponseDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.exceptions.ErrorResponseDto;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController {


	public RoleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleReporsitory   roleReporsitory;

	@PostMapping()
	public ResponseEntity<?> addRole(@Valid @RequestBody RoleDto roleDto) {
		RoleEntity roleEntity=this.roleService.addRoles(roleDto);

		return  new ResponseEntity<>(roleEntity,HttpStatus.CREATED);		
	}

	@GetMapping()
	public ResponseEntity<?>getAllroles(){



		List<RoleDto> findUser=this.roleService.getAllRoles();
		try {
			return new ResponseEntity<>(new SuccessResponseDto("success", "FoundALLroles", findUser),HttpStatus.OK);
		}catch(ResourceNotFoundException e) {

			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "NOT FOUND"),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getRoleById(@PathVariable(value = "id")Integer id){
		{
			RoleDto roleDto1=this.roleService.getRoleById(id);
			
			try {
				return new ResponseEntity<>(new SuccessResponseDto("Success","Success",roleDto1),HttpStatus.FOUND);
			}catch(ResourceNotFoundException e) {
				return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"User Not Found"),HttpStatus.NOT_FOUND);
			}
		}
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?>updateRols(@RequestBody RoleDto roleDto,@PathVariable(value = "id")Integer id){

		try 
		{
			this.roleService.updateRoles(roleDto, id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		}catch(ResourceNotFoundException e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "user notr found"),HttpStatus.BAD_REQUEST);

		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteRoles(@PathVariable(value = "id")Integer id){
		this.roleService.deletedRoles(id);
		
		try {
		
		return new ResponseEntity<>(new SuccessResponseDto("USER FOUND","DELETED","!!!!"),HttpStatus.FOUND);
		}
		catch(ResourceNotFoundException e) {
			return  new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"role Not Found"),HttpStatus.BAD_REQUEST);
			
		}
	}

	

	
	
	

}

