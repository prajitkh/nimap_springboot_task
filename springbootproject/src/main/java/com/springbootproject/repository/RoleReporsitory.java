package com.springbootproject.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootproject.entity.RoleEntity;

@Repository
public interface RoleReporsitory extends JpaRepository<RoleEntity, Integer>{
	
	 @Query("SELECT r FROM RoleEntity r WHERE r.roleName = :roleName")
	RoleEntity findByName(String roleName);

	 


}
