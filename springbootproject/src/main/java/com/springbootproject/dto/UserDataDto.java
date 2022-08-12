package com.springbootproject.dto;



public class UserDataDto {
	private int id;

	private String name;

	private String email;

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

	public UserDataDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDataDto(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

}
