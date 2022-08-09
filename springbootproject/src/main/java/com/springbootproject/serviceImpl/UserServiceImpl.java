package com.springbootproject.serviceImpl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.EditUserRequestDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.AssignRole;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.User;
import com.springbootproject.entity.UserRoleEntity;
import com.springbootproject.entity.UserRoleId;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.repository.UserRepo;

import com.springbootproject.service.UserService;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RoleReporsitory roleRepository;
	
	//
	//	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	//	private int batchSize;
	//

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
	//		@SuppressWarnings("unchecked")
	//		@Override
	//		public User addUserRole(RoleEntity roleId, int id) {
	//			List<RoleEntity>list=new ArrayList<>();
	//		User user =this.userRepo.findById(id).orElseThrow();
	//		for (RoleEntity roleEntity : list) {
	//			roleEntity.getId();
	//			RoleEntity roleEntity2=this.roleRepository.findById(id).get();
	//			roleEntity2.setUser((List<User>) user);
	//			list.add(roleEntity2);
	//			
	//		}
	//		user.setRoles(list);
	//		return userRepo.save(user);
	//		
	//		}
	
	

	@Override
	public void editUserRole(List<RoleEntity> entity, Integer id) {
		// TODO Auto-generated method stub
		
	}

	//			@Override
	//			public UserRoleEntity addRoleToUser( AssignRole  dto) {
	//			
	//				User user =userRepo.findByEmail(dto.getEmail());
	//				
	//				System.out.println("User " +user.getId());
	//			
	//				RoleEntity role = roleRepository.findByName(dto.getRoleName());
	//				
	//				System.out.println("role>>"+role.getId());
	//				
	//				UserRoleId userRoleId=new UserRoleId(user, role);
	//				
	//				UserRoleEntity roleEntity=new UserRoleEntity();
	//			
	//				roleEntity.setTask(userRoleId);
	//				return roleEntity;
	//	            
	//				
	//			}



//	@Override
//	public void editUserRole(Integer userId, EditUserRequestDto userBody) {
//		List<UserRoleEntity> list=new ArrayList<>();
//		UserRoleEntity entity=new UserRoleEntity();
//		User user= this.userRepo.findById(userId).get();
//
//		for(UserRoleEntity entity2: list) {
//			user.setId(userId);
//		RoleEntity entity3=new RoleEntity();
//		UserRoleId roleId=new UserRoleId(user, entity3);
//		entity.setTask(roleId);
//		list.add(entity2);
//		}
//		
//		list.add(entity);
//
//
//	}







public User  userToRole(List<Integer> roleId, int id) {
	User  user=this.userRepo.findById(id).orElseThrow();
	System.out.println(user.getRoles());

	for (Integer ids : roleId) {

		Optional<RoleEntity> entity=roleRepository.findById(ids);
		RoleEntity roleEntity=entity.get();
		
	
		user.getRoles().add(roleEntity);
		
		
	}
	return userRepo.save(user);
}
}
















