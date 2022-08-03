package com.springbootproject.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootproject.entity.User;
import com.springbootproject.repository.UserRepo;
@Service
public class CustemUserDetailService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	
			User user;
			user = userRepo.findByEmail(email);
			if (user == null)
			{
				throw new UsernameNotFoundException("User not found with Email: " + email);
			}

			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());
		}


}
