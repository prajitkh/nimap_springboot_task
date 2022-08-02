package com.springbootproject.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import com.springbootproject.entity.User;
import com.springbootproject.repository.UserRepo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil  {

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	private static final long serialVersionUID = -2550185165626007488L;

	

	public static final long JWT_TOKEN_VALIDITY_FORGOT_PASS = 5 * 60;
	@Autowired
	UserRepo userRepo;

	//std add properties file not write in class 
	@Value("jwtTokenKey")
	private String secret;


	// retrieve username from jwt token
	public String getEmailFromToken(String token) {
		System.out.println("fmail frm toekn "+ getClaimFromToken(token, Claims::getSubject));
		//		User user = getClaimFromToken(token, Claims::getSubject);
		return getClaimFromToken(token, Claims::getSubject);

	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {

		return getClaimFromToken(token, Claims::getExpiration);

	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = getAllClaimsFromToken(token);

		System.out.println("claims "+ claimsResolver.apply(claims));

		return claimsResolver.apply(claims);

	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {
		System.out.println("get all claims "+ Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());

		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {

		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());

	}


	// generate token for user
	public String generateToken(UserDetails userDetails) {

		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());

	}



	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + (JWT_TOKEN_VALIDITY * 1000))).signWith(SignatureAlgorithm.HS512, secret).compact();

	}



	// validate token
	public Boolean validateToken(String token, UserDetails userDetails) {

		return !isTokenExpired(token);

		// throw new ResourceNotFoundException("Timeout for this request");
	}
	// generate token for user
	public String generateTokenOnForgotPass(String email) {

		Map<String, Object> claims = new HashMap<>();
		return doGenerateTokenOnForgotPass(claims, email);

	}
	private String doGenerateTokenOnForgotPass(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + (JWT_TOKEN_VALIDITY_FORGOT_PASS * 1000))).signWith(SignatureAlgorithm.HS512, secret).compact();

	}



}


