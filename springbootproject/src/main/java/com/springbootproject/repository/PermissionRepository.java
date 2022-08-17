package com.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.entity.PermissionEntity;
@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {

}
