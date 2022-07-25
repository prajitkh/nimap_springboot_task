package com.springbootproject.dto;

import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

public class UserDto {


	private int id;
	
	private String name;

	private String email;
	public UserDto() {

		super();

		// TODO Auto-generated constructor stub
	}
	public UserDto(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
