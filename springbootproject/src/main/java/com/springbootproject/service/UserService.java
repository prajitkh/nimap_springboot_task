package com.springbootproject.service;


import java.util.List;
import org.springframework.stereotype.Service;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;



@Service
public interface UserService {

	UserDto  creatUser(UserDto user);

	UserDto updateUser(UserDto userDto,Integer id);

	UserDto getUserById(Integer userId);

	//	Page<UserDto> getAllUser(String search,String from,String to);

	
	User FindByEmail(String email);


	List<UserDto> getAllUser();

	public void deleteUser(Integer userId);
}







