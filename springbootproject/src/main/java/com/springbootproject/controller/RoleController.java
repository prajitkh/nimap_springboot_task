package com.springbootproject.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.springbootproject.dto.RoleDto;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.service.RoleService;
import com.springbootproject.serviceImpl.RoleServiceImpl;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleReporsitory   roleReporsitory;
	
	//@PostMapping()
	@PostMapping()
	public ResponseEntity<?> addRole(@Valid @RequestBody RoleDto roleDto) {
		RoleEntity roleEntity=this.roleService.addRoles(roleDto);
		return  new ResponseEntity<>(roleEntity,HttpStatus.CREATED);
		

		
	}
			
		
}

