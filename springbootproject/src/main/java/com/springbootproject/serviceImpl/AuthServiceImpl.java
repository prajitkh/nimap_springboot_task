package com.springbootproject.serviceImpl;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.springbootproject.entity.User;
import com.springbootproject.repository.AuthRepository;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.service.AuthInterface;

@Service
public class AuthServiceImpl implements AuthInterface {
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	private UserRepo userRepo;

	@Autowired
AuthRepository authRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user;
		user = authRepository.findByEmail(email);
		if (user == null)
		{
			throw new UsernameNotFoundException("User not found with Email: " + email);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());
	}

	@Override
	public Boolean comparePassword(String password, String hashPassword) 
	{
		return bcryptEncoder.matches(password, hashPassword);
	}
}
