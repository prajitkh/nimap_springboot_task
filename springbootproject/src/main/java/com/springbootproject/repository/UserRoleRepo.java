package com.springbootproject.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootproject.entity.UserRoleEntity;
import com.springbootproject.service.IUserRoleDetailDto;

public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer> {

	//List<RoleIdListDto>findByTaskUserId(Integer userId,Class<RoleIdListDto>RoleIdListDto);
	
ArrayList<IUserRoleDetailDto> findByTask(Integer userId, Class<IUserRoleDetailDto> IUserRoleDetailDto);

@Transactional
@Modifying(clearAutomatically = true)
@Query(value = "UPDATE user_role u SET is_active=false WHERE u.role_id=:role_id AND  u.user_id=:user_id",nativeQuery = true)
void deleteRole(@Param("role_id") int role_id,@Param("user_id") int user_id);



}
