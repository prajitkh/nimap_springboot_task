package com.springbootproject.service;

import org.springframework.stereotype.Service;

import com.springbootproject.dto.PermissionRequestDto;
import com.springbootproject.entity.PermissionEntity;
@Service
public interface PermissionServiceInterface {
	
	void addPermission(PermissionRequestDto permissionRequestDto);
	void editPermission(PermissionRequestDto permissionRequestDto ,int id);
	void deletePermission(int id);
}
