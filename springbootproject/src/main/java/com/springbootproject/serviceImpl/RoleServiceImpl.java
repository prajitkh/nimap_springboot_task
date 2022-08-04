package com.springbootproject.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.RoleDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.RoleEntity;
import com.springbootproject.entity.User;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.service.RoleService;

@Transactional
@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	UserRepo  userRepo;
	
	@Autowired
	RoleReporsitory roleReporsitory;
	



		@Override
		public RoleEntity addRoles(RoleDto roleDto) {
		RoleEntity roleEntity=new RoleEntity();
	
	
	roleEntity.setRoleName(roleDto.getRoleName());
	return roleReporsitory.save(roleEntity);
	
		
	}
		

}
