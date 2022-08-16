package com.springbootproject.repository;



import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springbootproject.entity.RoleEntity;

@Repository
@EnableJpaRepositories
public interface RoleReporsitory extends JpaRepository<RoleEntity, Integer>{
//@Transactional
//@Modifying(clearAutomatically =  true)
	@Query("SELECT r FROM RoleEntity r WHERE r.roleName = :roleName")
	RoleEntity findByName(String roleName);
	
	ArrayList<RoleEntity> findBy();
	




}
