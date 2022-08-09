package com.springbootproject.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootproject.entity.RoleEntity;

public class UserDto {

	private int id;
	

	//@Size(min = 10,message = "Username must be minimun 4 characters !!!")
	private String name;

	//@Email(message = "Email address is not valid" )

	private String email;


	@Size(min = 3,max = 10 ,message ="Password must be 3 char and max size 10 char !!")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	


	
//	private List<RoleEntity> roles;
//	
//	
//
//	public List<RoleEntity> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<RoleEntity> roles) {
//		this.roles = roles;
//	}





	public UserDto() {

		super();

		// TODO Auto-generated constructor stub
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDto(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}



}
