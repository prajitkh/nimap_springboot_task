 package com.springbootproject.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import com.springbootproject.dto.RoleIdListDto;
import com.springbootproject.dto.UserDataDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.dto.UserRoleDto;
import com.springbootproject.entity.AssignRole;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.User;
import com.springbootproject.entity.UserRoleEntity;
import com.springbootproject.entity.UserRoleId;
import com.springbootproject.exceptions.ErrorResponseDto;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.repository.UserRoleRepo;
import com.springbootproject.service.IUserRoleDetailDto;
import com.springbootproject.service.UserRoleService;
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRepo userRepo;


	@Autowired
	private UserRoleRepo userRoleRepo;

	@Autowired
	private RoleReporsitory roleReporsitory;
	@Autowired
	ModelMapper mapper;

	@Override
	public void addUserToRole(AssignRole assignRole) {

			ArrayList<UserRoleEntity>roles=new ArrayList<>();
			User user=this.userRepo.findById(assignRole.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User NOT Found "));
			RoleEntity role=this.roleReporsitory.findById(assignRole.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("ROLE NOT Found "));
			UserRoleId uri = new UserRoleId(user, role);
			UserRoleEntity ure = new UserRoleEntity();
			ure.setTask(uri);
			roles.add(ure);
			userRoleRepo.saveAll(roles);
		
	}

	@Override
	public void updateUserRoles(AssignRole assignRole){
		User user=this.userRepo.findById(assignRole.getUserId()).orElseThrow();
		RoleEntity role=this.roleReporsitory.findById(assignRole.getRoleId()).orElseThrow();
		UserRoleId uri = new UserRoleId(user, role);
		UserRoleEntity ure = new UserRoleEntity();
		ure.setTask(uri);
		
		userRoleRepo.updateUserRoles(user.getId(), role.getId());
	}

	@Override
	public List<UserRoleEntity> getAllUserRols1() {

		List<UserRoleEntity >list=this.userRoleRepo.findAll();
		//List<User> user= this.userRepo.findAll();

		return list;

	}

	@Override
	public UserRoleEntity deleteUserRoles(AssignRole assignRole) {
		
		User user =this.userRepo.findById(assignRole.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User NOT Found "));
		RoleEntity entity =this.roleReporsitory.findById(assignRole.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("Role NOT Found "));
//		User user =this.userRepo.findByEmail(assignRole.getEmail());
//	RoleEntity entity =this.roleReporsitory.findByName(assignRole.getRoleName());		
	UserRoleId id=new UserRoleId(user, entity);
		UserRoleEntity roleEntity=new UserRoleEntity();
		roleEntity.setTask(id);
//	this.userRoleRepo.deleteRole(user.getId(),entity.getId());
	this.userRoleRepo.delete(roleEntity);
		return roleEntity;
		
	


}

	
	
	
}












