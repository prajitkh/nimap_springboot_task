package com.springbootproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.entity.RoleEntity;
@Repository
public interface RoleReporsitory extends JpaRepository<RoleEntity, Integer>{
	Optional<RoleEntity> findByRoleNameContainingIgnoreCase(String name);
	

}