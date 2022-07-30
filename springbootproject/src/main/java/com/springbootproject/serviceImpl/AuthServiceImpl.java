package com.springbootproject.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springbootproject.dto.UserDto;
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
		
		if (user == null) {

			throw new UsernameNotFoundException("User not found with Email: " + email);

		}

return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),new ArrayList<>());


	}






	@Override
	public Boolean comparePassword(String password, String hashPassword) {
	
		return bcryptEncoder.matches(password, hashPassword);
	}

public 	User save(UserDto user) {
	User u1=new User();
	u1.setEmail(user.getEmail());
	u1.setPassword(bcryptEncoder.encode(user.getPassword()));
	return userRepo.save(u1);
}


  

}
