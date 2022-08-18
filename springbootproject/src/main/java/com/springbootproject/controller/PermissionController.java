package com.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.dto.PermissionRequestDto;
import com.springbootproject.dto.SuccessResponseDto;
import com.springbootproject.entity.PermissionEntity;
import com.springbootproject.exceptions.ErrorResponseDto;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.service.PermissionServiceInterface;

@RestController
@RequestMapping("/permission")
public class PermissionController {


	public PermissionController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private PermissionServiceInterface permissionServiceInterface;


	@PostMapping
	public ResponseEntity<?> addPermissions( @RequestBody PermissionRequestDto permissionRequestDto){
		this.permissionServiceInterface.addPermission(permissionRequestDto);
		return new ResponseEntity<>("Success",HttpStatus.OK);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>editPermission(@PathVariable int id,@RequestBody PermissionRequestDto permissionRequestDto)
	{
		try {
		this.permissionServiceInterface.editPermission(permissionRequestDto, id);
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}catch(ResourceNotFoundException e) {
		return new ResponseEntity<>(new ErrorResponseDto("method not found", null),HttpStatus.BAD_REQUEST);
	}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deletePermission(@PathVariable int id){
		
		this.permissionServiceInterface.deletePermission(id);
		return  ResponseEntity.ok(HttpStatus.OK);
		
	}
		
	
		
	}