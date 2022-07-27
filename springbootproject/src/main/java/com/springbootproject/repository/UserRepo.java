package com.springbootproject.repository;




import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;

@Repository

public interface UserRepo extends JpaRepository<User, Integer> {
//
////	@Query(name = "select new com.springbootproject.dto.UserDto(u.name,u.email)from User u")
//Page<IUserDto>findByOrderById(Pageable paging, Class<IUserDto> UserDto);
////@Query(name = "select u From User u WHERE u.name= :n")
//	
//Page<IUserDto> findByName(String search,Pageable paging,Class<IUserDto> UserDto);
//
//Page<IUserDto> findByName(String search, org.springframework.data.domain.Pageable paging, Class<UserDto> class1);
	

	
}
