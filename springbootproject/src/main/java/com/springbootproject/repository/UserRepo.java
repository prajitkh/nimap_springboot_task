package com.springbootproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByIdAndisActiveTrue(Integer id);

	List<User> findByIdAndisActiveTrue();
	
	

	
	
}
