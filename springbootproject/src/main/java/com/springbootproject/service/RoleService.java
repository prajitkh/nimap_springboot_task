package com.springbootproject.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootproject.dto.RoleDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.RoleEntity;
@Service
public interface RoleService {


	RoleEntity addRoles(RoleDto roleDto);

	List<RoleDto> getAllRoles( );

	void  updateRoles(RoleDto roleDto,int id);


	void deletedRoles(Integer id);
	
	
	RoleDto  getRoleById(Integer id);
	
	void addRoleToUser(String email, String roleName);
}
