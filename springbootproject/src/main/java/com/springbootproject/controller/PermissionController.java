package com.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.dto.PermissionRequestDto;
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

}
	
