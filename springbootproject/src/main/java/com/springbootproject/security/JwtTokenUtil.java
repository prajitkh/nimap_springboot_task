package com.springbootproject.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil  {
	

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	
	
	
	//std add properties file not write in class 
	private String secret="jwtTokenKey";
	
	// retrieve username from jwt token
	public String getEmailFromToken(String token) {

		return getClaimFromToken(token, Claims::getSubject);

	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {

		return getClaimFromToken(token, Claims::getExpiration);

	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);

	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {

		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {

		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());

	}
}
