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
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.dto.JwtAuthRequest;
import com.springbootproject.entity.User;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.security.CustomUserDetailsService;
import com.springbootproject.security.JwtAuthResponse;
import com.springbootproject.security.JwtTokenUtil;
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
	private AuthServiceImpl authServiceImpl;

	@Autowired
	private AuthenticationManager authenticationManager;

	//create login api  to create tokean


	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest request ) throws Exception {

	User userEntity = userRepo.findByEmail(request.getEmail());

			if (!authServiceImpl.comparePassword(request.getPassword(), userEntity.getPassword())) {

				return new ResponseEntity<>(new com.springbootproject.exceptions.ErrorResponseDto(null, null), HttpStatus.UNAUTHORIZED);
			}

			System.out.println("DATa"+userEntity.getEmail());
			final String token = jwtTokenUtil.generateToken(userEntity);

			System.out.println(token);
			return new ResponseEntity<>(token ,HttpStatus.OK);

		}
	
}



	//List<IPermissionDto> permissions = userServiceInterface.getUserPermission(userEntity.getId());
	//				LoggerDto logger = new LoggerDto();
	//				logger.setToken(token);
	//				Calendar calender = Calendar.getInstance();
	//				calender.add(Calendar.HOUR_OF_DAY, 5);
	//				logger.setExpireAt(calender.getTime());
	//				loggerServiceInterface.createLogger(logger, userEntity);

	//return new ResponseEntity<>(new SuccessResponseDto("Success", "success", new AuthResponseDto(token, permissions,userEntity.getEmail(),userEntity.getName(),userEntity.getId())), HttpStatus.OK);

	//			} catch (ResourceNotFoundException e) {
	//
	//				return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "userNotFound"), HttpStatus.NOT_FOUND);


