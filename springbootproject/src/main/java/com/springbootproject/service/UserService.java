package com.springbootproject.service;


import java.util.List;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.EditUserRequestDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.User;



@Service
public interface UserService {

	User  creatUser(UserDto user);

	void updateUser(UserDto userDto,Integer id);

	UserDto getUserById(Integer userId);

	//	Page<UserDto> getAllUser(String search,String from,String to);
	User FindByEmail(String email);


	List<UserDto> getAllUser();

	public void deleteUser(Integer userId);

// User addUserRole(RoleEntity roleId,int id);

	void editUserRole(Integer userId, UserDto userBody);
 
 
	//public void addRoleToCandidate(Integer userId, Integer roleId);
	
	///public void addRoleToUser(String email, String roleName);
	}








