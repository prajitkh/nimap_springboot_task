package com.springbootproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootproject.entity.AssignPermission;
import com.springbootproject.entity.RolePermissionEntity;

@Service
public interface RolePermissionService {
void addPermissionToRole(AssignPermission assignPermission);
	
List<RolePermissionEntity> getAllRolePermission();
ArrayList<String> getPermissionByUserId(Integer userId);
	
	
}
