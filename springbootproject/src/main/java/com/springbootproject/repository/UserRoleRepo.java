package com.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootproject.entity.UserRoleEntity;

public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer> {

}
