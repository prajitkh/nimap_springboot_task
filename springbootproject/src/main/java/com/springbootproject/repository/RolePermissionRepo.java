package com.springbootproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.dto.IPermissionIdList;
import com.springbootproject.entity.RolePermissionEntity;
@Repository
public interface RolePermissionRepo  extends JpaRepository<RolePermissionEntity, Integer>{

	//List<IPermissionIdList> findPkPermissionByPkRoleIdIn(ArrayList<Integer> roleIds, Class<IPermissionIdList> IPermissionIdList);

	//List<IPermissionDto> findByPkRoleIdIn(ArrayList<Long> roleIds, Class<IPermissionDto> IPermissionDto);

	
	List<IPermissionIdList> findPkPermissionByPkRoleIdIn(ArrayList<Integer> roleIds, Class<IPermissionIdList> IPermissionIdList);




}
