package com.springbootproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootproject.entity.AssignRole;
import com.springbootproject.entity.UserRoleEntity;

@Service
public interface UserRoleService {

	//public User editUserRole(Integer userId,List<Integer> rolId);
	void editUserRole(AssignRole assignRole);

	
	List<UserRoleEntity> getAllUserRole(UserRoleEntity userRoleEntity);
}
