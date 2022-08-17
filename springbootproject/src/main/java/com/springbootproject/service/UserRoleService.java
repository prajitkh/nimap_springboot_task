package com.springbootproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootproject.dto.RoleIdListDto;
import com.springbootproject.dto.UserDataDto;
import com.springbootproject.dto.UserRoleDto;
import com.springbootproject.entity.AssignRole;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.User;
import com.springbootproject.entity.UserRoleEntity;

@Service
public interface UserRoleService {

	//public User editUserRole(Integer userId,List<Integer> rolId);
	void addUserToRole(AssignRole assignRole);

List<UserRoleEntity> getAllUserRols1();

//List<UserRoleEntity> getAllUsersCount(Integer userId);



//void deleteUserRoles(AssignRole assignRole);


UserRoleEntity deleteUserRoles(AssignRole assignRole);

void updateUserRoles(AssignRole assignRole);


}
