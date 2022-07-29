package com.springbootproject.dto;


import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class JwtAuthRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 45866014922086742L;
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public JwtAuthRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public JwtAuthRequest() {
		super();
	
	}
	

}
