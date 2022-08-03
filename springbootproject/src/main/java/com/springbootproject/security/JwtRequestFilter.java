package com.springbootproject.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.springbootproject.serviceImpl.AuthServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;





@Component
public class JwtRequestFilter  extends OncePerRequestFilter{

	

@Autowired
private AuthServiceImpl authServiceImpl;

@Autowired
private UserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil   jwtTokenUtil;

	///when api hit -jwt token fetch --
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//1.get token--from header
		//key authoriaztion 

		final String requestToken=request.getHeader("Authorization"); 

		//2 .token start from Bearer 23434ghfd


		System.out.println(requestToken);  

		String email=null;
		String token=null;

		
		if(requestToken !=null && requestToken.startsWith("Bearer "))
		{
			token =requestToken.substring(7);

			try {
				System.out.println("TOKEN "+token);
				email = this.jwtTokenUtil.getEmailFromToken(token);
				
			}	catch(IllegalArgumentException e)
			{
 
				System.out.println(" Unable to get Jwt token");
			}
			catch(ExpiredJwtException e)
			{

				System.out.println("Jwt token has expired !!!!!!!!!!");
			}
			catch(IllegalStateException e) 
			{
				System.out.println("Cant not convert to JSON");
			}
			catch(NullPointerException e)
			{
				System.out.println("Null Value Not Allowed...");
			}
		}
		else 
		{
			logger.warn("JWT token  Dose not start with Bearer ");
		}

		//once we get token token ,now validate

		if(email != null && SecurityContextHolder.getContext().getAuthentication() ==null)
		{
			UserDetails userDetails=this.userDetailsService.loadUserByUsername(email);
		
			//validate need username detials to use userdetails service 
			if(this.jwtTokenUtil.validateToken(token, userDetails))
			{

				//set authetication ---create authi object need --create userpass
				//one type authication 
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			}
		}

		filterChain.doFilter(request, response);


	}
}

