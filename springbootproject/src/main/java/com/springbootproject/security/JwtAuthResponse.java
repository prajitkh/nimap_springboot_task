package com.springbootproject.security;

public class JwtAuthResponse {
	
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtAuthResponse [token=" + token + "]";
	}

	public JwtAuthResponse(String token2) {
		super();
		
	}
	

}
