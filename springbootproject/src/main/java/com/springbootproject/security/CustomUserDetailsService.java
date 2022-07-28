package com.springbootproject.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootproject.entity.User;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.UserRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading user from database by username
		
User user=	this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("us NOt found"+username));
		return  user;
		
	
	}


	}
	
	
	
	
