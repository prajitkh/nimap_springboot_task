package com.springbootproject.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.UserDto;


@Service
public interface UserService {

	UserDto  creatUser(UserDto user);

	UserDto updateUser(UserDto userDto,Integer id);

	UserDto getUserById(Integer userId);

	Page<UserDto> getAllUser(String search,String from,String to);

	public void deleteUser(Integer userId);






}







