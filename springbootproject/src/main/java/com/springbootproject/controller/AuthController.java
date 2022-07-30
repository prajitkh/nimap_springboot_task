package com.springbootproject.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.springbootproject.dto.JwtAuthRequest;
import com.springbootproject.dto.LoggerDto;
import com.springbootproject.dto.SuccessResponseDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.exceptions.ErrorResponseDto;
import com.springbootproject.exceptions.ResourceNotFoundException;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.security.CustomUserDetailsService;
import com.springbootproject.security.JwtAuthResponse;
import com.springbootproject.security.JwtTokenUtil;
import com.springbootproject.service.LoggerServiceInterface;
import com.springbootproject.service.UserService;
import com.springbootproject.serviceImpl.AuthServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired 
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private JwtAuthRequest jwtAuthRequest;
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;
	@Autowired
	private LoggerServiceInterface loggerServiceInterface;

	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	

	@Autowired
	private AuthServiceImpl authServiceImpl;


	//create login api  to create tokean



	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtAuthRequest authenticationRequest)  {

		try {

			User user = userRepo.findByEmail(authenticationRequest.getEmail());

			String password=passwordEncoder.encode(user.getPassword());
			if (!authServiceImpl.comparePassword(authenticationRequest.getPassword(), user.getPassword())) {

				return new ResponseEntity<>(new ErrorResponseDto("Invalid Credential", "invalidCreds"),HttpStatus.UNAUTHORIZED);
			}
			System.out.println("DATA"+user.getEmail());
			
			final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
			final String token = jwtTokenUtil.generateToken(user);


			//List<IPermissionDto> permissions = userServiceInterface.getUserPermission(userEntity.getId());
			LoggerDto logger = new LoggerDto();
			logger.setToken(token);
			Calendar calender = Calendar.getInstance();

		calender.add(Calendar.HOUR_OF_DAY, 5);
		logger.setExpireAt(calender.getTime());

			loggerServiceInterface.createLogger(logger, user);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "success", new JwtAuthResponse(token)), HttpStatus.OK);

		} catch (ResourceNotFoundException e) {

			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"User Not Found"),HttpStatus.NOT_FOUND);

		}
		}
	}















