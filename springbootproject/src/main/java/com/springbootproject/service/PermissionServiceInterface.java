package com.springbootproject.service;

import org.springframework.stereotype.Service;

import com.springbootproject.dto.PermissionRequestDto;
@Service
public interface PermissionServiceInterface {
	void addPermission(PermissionRequestDto permissionRequestDto);
	
}
