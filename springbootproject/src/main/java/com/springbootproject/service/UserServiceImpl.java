package com.springbootproject.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.pagination.Pagination;
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
		return user;
	}

	private UserDto userToDto(User user)
	{
		UserDto userDto=this.modelMapper.map(user,UserDto.class);
		return userDto;
	}

	//post user new create
	@Override
	public UserDto creatUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User saveUser=this.userRepo.save(user);
		return this.userToDto(saveUser);
	}

	@Override
	public UserDto getUserById(Integer userId)
	{
		User user=this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found With ID :" +userId)) ;
		return this.userToDto(user);
	}

	//get All user
	@Override
	public  Page<UserDto> getAllUser(String search,String from,String to) 
	{
		
		Pageable paging= new Pagination().getPagination(from, to);
		
		if((search == "") || (search == null ) || (search.length() == 0)) {
			return userRepo.findByOrdrById(paging,UserDto.class);
		}
		else {
			
		return userRepo.findByName(search, paging, UserDto.class);
		
		}
	}
	

	
	
	
	
	
	//update User
	@Override
	public UserDto updateUser(UserDto userDto, Integer id) {
		User user= this.userRepo.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("User not found with Id :"+id));
		//User user=this.dtoToUser(userDto);
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());

		User updateUser=this.userRepo.save(user);
		UserDto saveUser=this.userToDto(updateUser);

		return saveUser;
	}

	@Override
	public void deleteUser(Integer userId)
	{
		this.userRepo.findById(userId).orElseThrow( () ->
		new ResourceNotFoundException("User Not Found With Id :"+userId));
		this.userRepo.deleteById(userId);
	}


}






