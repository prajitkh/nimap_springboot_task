package com.springbootproject.serviceImpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootproject.entity.User;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.service.AuthInterface;

@Service
public class AuthServiceImpl implements AuthInterface {
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	private UserRepo userRepo;

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
User user;

		user = userRepo.findByEmail(email);
	return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),null);

	}

	@Override
	public Boolean comparePassword(String password, String hashPassword) {
	
		return bcryptEncoder.matches(password, hashPassword);
	}



}
