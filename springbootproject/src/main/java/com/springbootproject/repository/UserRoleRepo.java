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
@Repository
public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer> {

	//List<RoleIdListDto>findByTaskUserId(Integer userId,Class<RoleIdListDto>RoleIdListDto);
	
ArrayList<IUserRoleDetailDto> findByTask(Integer userId, Class<IUserRoleDetailDto> IUserRoleDetailDto);

@Transactional
@Modifying(clearAutomatically =  true)
@Query(value ="update user_role u SET  role_id=:role_id WHERE u.user_id=:user_id",nativeQuery =true)
void updateUserRoles(@Param("role_id") Integer role_id,@Param("user_id") Integer userId);







}
