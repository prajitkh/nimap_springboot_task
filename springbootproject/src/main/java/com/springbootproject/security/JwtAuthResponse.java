package com.springbootproject.security;

import java.io.Serializable;

public class JwtAuthResponse  implements Serializable{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7412640266149798683L;


	private String token;


	public String getToken() {
		return this.token;
	}


	public JwtAuthResponse(String token) {
		super();
		this.token = token;
		
	}


}