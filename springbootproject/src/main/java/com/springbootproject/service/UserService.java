package com.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;

@Service
public interface UserService {
	
UserDto  creatUser(UserDto user);

UserDto updateUser(UserDto userDto,Integer id);



  UserDto getUserById(Integer userId);

 List<UserDto> getAllUser();
 

 void deleteUser(Integer userId);




	
}



		



