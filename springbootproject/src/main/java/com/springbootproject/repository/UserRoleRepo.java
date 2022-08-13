package com.springbootproject.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.springbootproject.entity.UserRoleEntity;
import com.springbootproject.service.IUserRoleDetailDto;

public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer> {

	//List<RoleIdListDto>findByTaskUserId(Integer userId,Class<RoleIdListDto>RoleIdListDto);
	
ArrayList<IUserRoleDetailDto> findByTask(Integer userId, Class<IUserRoleDetailDto> IUserRoleDetailDto);

}
