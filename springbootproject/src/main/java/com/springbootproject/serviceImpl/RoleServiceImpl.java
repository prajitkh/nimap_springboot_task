package com.springbootproject.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.RoleDto;

import com.springbootproject.entity.RoleEntity;

import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.RoleReporsitory;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.service.RoleService;


@Transactional
@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService{



	@Autowired
	RoleReporsitory roleReporsitory;
	@Autowired
	UserRepo userRepo;


	@Autowired
	ModelMapper modelMapper;


	@Override
	public RoleEntity addRoles(RoleDto roleDto) {
		RoleEntity roleEntity=new RoleEntity();
		roleEntity.setRoleName(roleDto.getRoleName());
		return roleReporsitory.save(roleEntity);


	}
	//getting  all roles
	@Override
	public List<RoleDto> getAllRoles() {
		List<RoleEntity> roles=this.roleReporsitory.findAll();
		List<RoleDto> saveRoles=roles.stream().map(e -> this.modelMapper.map(e, RoleDto.class)).collect(Collectors.toList());
		return saveRoles;
	}
	@Override
	public void updateRoles(RoleDto roleDto, int id) {
		RoleEntity  role=this.roleReporsitory.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role NOT Found "+id));
		role.setRoleName(roleDto.getRoleName());
		roleReporsitory.save(role);

	}


	@Override
	public void deletedRoles(Integer id) {
		this.roleReporsitory.findById(id)
		.orElseThrow( () -> new ResourceNotFoundException("role not found"+id));
		this.roleReporsitory.deleteById(id);

	}


	@Override
	public RoleDto getRoleById(Integer id) {
		RoleEntity roleEntity=this.roleReporsitory.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ROLE NOT FOUND WITH ID"+id));
		return this.modelMapper.map(roleEntity, RoleDto.class);
	}
}
