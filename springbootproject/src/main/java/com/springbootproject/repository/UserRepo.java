package com.springbootproject.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.entity.User;
import com.springbootproject.service.IUserRoleDetailDto;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmail(String email);

	ArrayList<IUserRoleDetailDto> findByTaskUserIdAndTaskUser(Integer userId, Class<IUserRoleDetailDto> IUserRoleDetailDto);






}
