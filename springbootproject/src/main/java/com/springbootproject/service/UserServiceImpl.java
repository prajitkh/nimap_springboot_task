package com.springbootproject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.UserRepo;
@Service

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;


	@Autowired
	private ModelMapper modelMapper;

	private User dtoToUser(UserDto userDto)
	{
		//convert dto to user --1 add source class?,class object add 

		User user= this.modelMapper.map(userDto,User.class );
		//		user.setId(userDto.getId());
		//		user.setName(userDto.getName());
		//		user.setEmail(userDto.getEmail());
		return user;


	}

	private UserDto userToDto(User user) {
		UserDto userDto=this.modelMapper.map(user,UserDto.class);
		//		UserDto userDto= new UserDto();
		//		userDto.setId(user.getId());
		//		userDto.setName(user.getName());
		//		userDto.setEmail(user.getEmail());

		return userDto;
	}

	@Override
	public UserDto creatUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User saveUser=this.userRepo.save(user);


		return this.userToDto(saveUser);
	}


	


	

	@Override
	public UserDto getUserById(Integer userId) {
		User user=this.userRepo.findById(userId).orElse(null);
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> list=this.userRepo.findAll();
		List<UserDto> getlist=list.stream().map(e -> this.userToDto(e)).collect(Collectors.toList());

		return getlist;
	}



	@Override
	public UserDto updateUser(UserDto userDto, Integer id) {

		User user= this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("users", "id", id));
		//User user=this.dtoToUser(userDto);
		user.setEmail(userDto.getEmail());
		user.setId(userDto.getId());
		user.setName(userDto.getName());
	

       //
		User updateUser=this.userRepo.save(user);
		UserDto saveUser=this.userToDto(updateUser);

		return saveUser;
	}

	@Override
	public void  deleteUser(Integer userId) {
	User user=	this.userRepo.findById(userId).orElseThrow(()  -> new ResourceNotFoundException("User", "Id", userId));
		
		this.userRepo.delete(user);
		
	
	
		
	}



}


