package com.springbootproject.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.entity.UserRoleEntity;

public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Integer>{

}
