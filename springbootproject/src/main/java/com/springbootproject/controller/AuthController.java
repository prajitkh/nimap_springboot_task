package com.springbootproject.controller;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springbootproject.dto.JwtAuthRequest;
import com.springbootproject.dto.LoggerDto;
import com.springbootproject.dto.UserDto;
import com.springbootproject.entity.User;
import com.springbootproject.exceptions.ApiExceptions;
import com.springbootproject.exceptions.ErrorResponseDto;
import com.springbootproject.repository.UserRepo;
import com.springbootproject.security.JwtAuthResponse;
import com.springbootproject.security.JwtTokenUtil;
import com.springbootproject.service.LoggerServiceInterface;
import com.springbootproject.serviceImpl.AuthServiceImpl;
import com.springbootproject.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private LoggerServiceInterface loggerServiceInterface;

	@Autowired
	private AuthServiceImpl authServiceImpl;

	@Autowired
	private UserServiceImpl userServiceImpl;

	//create login api  to create tokean
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtAuthRequest authenticationRequest) {

		try {

			User user = userRepo.findByEmail(authenticationRequest.getEmail());
			System.out.println(user.getPassword());

			if (authServiceImpl.comparePassword(authenticationRequest.getPassword(), user.getPassword())) {

				System.out.println("DATA"+user.getEmail());
				final UserDetails userDetails=userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
				final String token = jwtTokenUtil.generateToken(userDetails);

				LoggerDto logger = new LoggerDto();
				logger.setToken(token);
				Calendar calender = Calendar.getInstance();
				calender.add(Calendar.HOUR_OF_DAY, 5);
				logger.setExpireAt(calender.getTime());
				loggerServiceInterface.createLogger(logger, user);
				return new ResponseEntity<>( new JwtAuthResponse(token), HttpStatus.OK);
			}
		}catch(BadCredentialsException e) {
			throw new ApiExceptions("INVALID USERNAME OR PASSWORD");

		}catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(),"User Not Found"),HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(new ErrorResponseDto("Invalid PASSWORD", "CHECK PASSWORD"),HttpStatus.UNAUTHORIZED);

	}

	@PostMapping("/register")
	public ResponseEntity<?>createUser(@Valid @RequestBody UserDto userDto )
			throws Exception	{

		return ResponseEntity.ok(userServiceImpl.creatUser(userDto));

	}

	@Transactional
	@RequestMapping(value = "/logout",method = RequestMethod.POST)
	public ResponseEntity<?> logoutUser(@RequestHeader("Authorization") String token, HttpServletRequest request) {
		loggerServiceInterface.logout(token);
		return new ResponseEntity<>(new ErrorResponseDto("Logout Successfully", "logoutSuccess"), HttpStatus.OK);

	}
}















