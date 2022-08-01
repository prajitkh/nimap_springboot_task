package com.springbootproject.security;

import java.io.Serializable;

public class JwtAuthResponse  implements Serializable{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7412640266149798683L;


	private String token;
	

	private String email;

	private String name;

	private int  id;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JwtAuthResponse(String token) {
		super();
		this.token = token;
		
	}

	public JwtAuthResponse(String token, String email, String name, int id) {
		super();
		this.token = token;
		this.email = email;
		this.name = name;
		this.id = id;
	}
	

}