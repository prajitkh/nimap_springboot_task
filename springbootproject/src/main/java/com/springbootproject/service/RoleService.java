package com.springbootproject.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.springbootproject.dto.RoleDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.RoleEntity;
@Service
public interface RoleService {
	
	RoleEntity addRoles(RoleDto roleDto);




}
