package com.springbootproject.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.springbootproject.entity.User;
import com.springbootproject.repository.AuthRepository;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.service.AuthInterface;
import com.springbootproject.service.RolePermissionService;

@Service
public class AuthServiceImpl implements AuthInterface {
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	
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

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),getAuthority(user));
	}
	
	


		private ArrayList< SimpleGrantedAuthority> getAuthority(User user) {
			ArrayList<SimpleGrantedAuthority>authorities=new ArrayList<>();
			
			if((user.getId() + "permission") != null) {
				ArrayList<SimpleGrantedAuthority>authorities1=new ArrayList<>();
				
				System.out.println("auth1233"+authorities1);
				
				
				ArrayList<String> permissions= this.rolePermissionService.getPermissionByUserId(user.getId()); 
				

				System.out.println("permission"+permissions);
				
				
				
				permissions.forEach(e -> {authorities1.add(new SimpleGrantedAuthority("ROLE_"+e));
		
				});
	    		authorities=authorities1;
		


		}
			System.out.println("authorites>>>>>"+authorities);
			return authorities;
		}
	



	@Override
	public Boolean comparePassword(String password, String hashPassword) 
	{
		return bcryptEncoder.matches(password, hashPassword);
	}
}
