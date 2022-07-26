package com.springbootproject.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


 Page<UserDto>findByOrdrById(Pageable paging, Class<UserDto> UserDto);
//	 
  Page<UserDto> findByName(String name,Pageable paging,Class<UserDto> UserDto);


	


	
	
}
