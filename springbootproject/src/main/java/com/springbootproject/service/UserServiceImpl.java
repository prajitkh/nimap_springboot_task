package com.springbootproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.repository.UserRepo;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo userRepo;

	private User dtoToUser(UserDto userDto)
	{
		User user= new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		return userRepo.save(user);


	}

	private UserDto UserToDto(User user) {

		UserDto userDto= new UserDto();
		userDto.setId(userDto.getId());
		userDto.setName(userDto.getName());
		userDto.setEmail(userDto.getEmail());

		return userDto;
	}

	@Override
	public UserDto creatUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User saveUser=this.userRepo.save(user);
		return this.UserToDto(saveUser);
	}

	@Override
	public List<UserDto> getAllUser() {
		
		List<User>findAll=this.userRepo.findAll();
		
List<UserDto>list=findAll.stream().map(e -> this.UserToDto(e)).collect(Collectors.toList());
return list;
		
	}



	//*	@Override
	//	public void createUser(UserDto user) {
	//	User usernew=new User();
	//	usernew.setName(user.getName());
	//	usernew.setEmail(user.getEmail());
	//	usernew.setId(user.getId());
	//userRepo.save(usernew);



	//@Override
	//	public List<User> getAllUser() {

	//	return userRepo.findByIdAndisActiveTrue();
	//}

}
