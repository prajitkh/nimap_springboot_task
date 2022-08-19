package com.springbootproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.dto.SuccessResponseDto;
import com.springbootproject.entity.AssignPermission;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.RolePermissionEntity;
import com.springbootproject.service.RolePermissionService;

@RestController
@RequestMapping("role-permission")
public class RolePermissionController {
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	
	@PostMapping
	public ResponseEntity<?>addPermissionToRole(@RequestBody AssignPermission assignPermission){
		this.rolePermissionService.addPermissionToRole(assignPermission);
		System.out.println("ID per"+assignPermission.getPerId());
		System.out.println("ID role"+assignPermission.getRoleId());
		return ResponseEntity.ok(HttpStatus.CREATED);
		
	}
	
	
	@GetMapping
	public ResponseEntity<?>getAllRolesPermission(){

	List<RolePermissionEntity> list=	this.rolePermissionService.getAllRolePermission();
				
	
		return  ResponseEntity.ok(new SuccessResponseDto("Role permission", "succefully shown", list));
	
	
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getPermissionByuserId(@PathVariable int id){
		
ArrayList<String> roleEntity	=this.rolePermissionService.getPermissionByUserId(id);
		return new ResponseEntity<>(roleEntity,HttpStatus.OK);
			
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
