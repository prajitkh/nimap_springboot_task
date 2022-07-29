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

import io.jsonwebtoken.ExpiredJwtException;


@Component
public class JwtRequestFilter  extends OncePerRequestFilter{

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

		String requestToken=request.getHeader("Authorization"); 

		//2 .token start from Bearer 23434ghfd


		System.out.println(requestToken);  
		String username=null;
		String token=null;


		if(requestToken !=null && requestToken.startsWith("Bearer"))
		{
			token =requestToken.substring(7);

			try {
				username  = this.jwtTokenUtil.getEmailFromToken(token);
			}
			catch(IllegalArgumentException e) {
				System.out.println(" Unable to get Jwt token");
			}catch(ExpiredJwtException e) {
				System.out.println("Jwt token has expired !!!!!!!!!!");
			}
		}else {
			System.out.println("jwt token dose not begin with  Bearer");
		}
		//once we get token token ,now validate

		if(username != null && SecurityContextHolder.getContext().getAuthentication() ==null)
		{
			UserDetails userDetails=this.userDetailsService.loadUserByUsername(username);

			//validate need username detials to use userdetails service 
			if(this.jwtTokenUtil.validateToken(token, userDetails)) {

				//set authetication ---create authi object need --create userpass
				//one type authication 
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}else {
				System.out.println("invalid Jwt Token");
			}

		}else {
			System.out.println("username  null or context is not null");
		}

		filterChain.doFilter(request, response);





	}

}
