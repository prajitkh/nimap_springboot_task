package com.springbootproject.serviceImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.exceptions.ResourceNotFoundException;


import com.springbootproject.repository.UserRepo;

import com.springbootproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	private User dtoToUser(UserDto userDto)
	{
		//convert dto to user --1 add source class?,class object add 
		User user= this.modelMapper.map(userDto,User.class );
		return user;
	}

	private UserDto userToDto(User user)
	{
		UserDto userDto=this.modelMapper.map(user,UserDto.class);
		return userDto;
	}

	//post user new create
	@Override
	public User creatUser(UserDto userDto) {
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		//return "User Registration successful......!!!!!!!!!!!!!!";

		return this.userRepo.save(user);




	}

	@Override
	public UserDto getUserById(Integer userId)
	{
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found With ID :" +userId)) ;
		return this.userToDto(user);
	}


	//update User
	@Override
	public void updateUser(UserDto userDto, Integer id) {
		User user= this.userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with Id :"+id));
		user.setName(userDto.getName());
		userRepo.save(user);



	}

	@Override
	public void deleteUser(Integer userId)
	{
		this.userRepo.findById(userId).orElseThrow( () ->
		new ResourceNotFoundException("User Not Found With Id :"+userId));
		this.userRepo.deleteById(userId);
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> user= this.userRepo.findAll();
		List<UserDto>save=user.stream().map(e  -> this.userToDto(e)).collect(Collectors.toList());
		return save;


	}

	@Override
	public User FindByEmail(String email) {
		User user =this.userRepo.findByEmail(email);
		return  user;

	}

}









