package com.springbootproject.service;


import java.util.List;
import org.springframework.stereotype.Service;
import com.springbootproject.dto.UserDto;



@Service
public interface UserService {

	UserDto  creatUser(UserDto user);

	UserDto updateUser(UserDto userDto,Integer id);

	UserDto getUserById(Integer userId);

	//	Page<UserDto> getAllUser(String search,String from,String to);



	List<UserDto> getAllUser();

	public void deleteUser(Integer userId);
}







