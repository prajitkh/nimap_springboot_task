package com.springbootproject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.PermissionRequestDto;
import com.springbootproject.entity.PermissionEntity;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.PermissionRepository;
import com.springbootproject.service.PermissionServiceInterface;
@Service
public class PermissionServiceImpl  implements PermissionServiceInterface{

	

	
	@Autowired
	private PermissionRepository permissionRepository;
	
	

	@Override
	public void addPermission(PermissionRequestDto permissionRequestDto) {
	
		
		PermissionEntity permissionEntity=new PermissionEntity();
		permissionEntity.setActionName(permissionRequestDto.getActionName());
		permissionEntity.setBaseUrl(permissionRequestDto.getBaseUrl());
		permissionEntity.setDescription(permissionRequestDto.getDescription());
		permissionEntity.setMethod(permissionRequestDto.getMethod());
		permissionEntity.setPath(permissionRequestDto.getPath());
		permissionRepository.save(permissionEntity);
		return;
	}


	@Override
	public void editPermission(PermissionRequestDto permissionRequestDto, int id) {
		PermissionEntity permissionEntity=this.permissionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("role Not found "));
		
		permissionEntity.setActionName(permissionRequestDto.getActionName());
		permissionEntity.setBaseUrl(permissionRequestDto.getBaseUrl());
		permissionEntity.setDescription(permissionRequestDto.getDescription());
		permissionEntity.setMethod(permissionRequestDto.getMethod());
		permissionEntity.setPath(permissionRequestDto.getPath());
		permissionRepository.save(permissionEntity);
		return;
	}


	@Override
	public void deletePermission(int id) {
		PermissionEntity permissionEntity2=this.permissionRepository.findById(id).orElseThrow();
	this.permissionRepository.delete(permissionEntity2);
		
	}
	
	
	

}
