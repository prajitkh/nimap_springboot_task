package com.springbootproject.dto;



public class UserDto {

	private int id;
	
	//@NotNull
	//@Size(min = 10,message = "Username must be minimun 4 characters !!!")
	private String name;

	//@Email(message = "Email address is not valid" )
	private String email;


	//@Size(min = 3,max = 10 ,message ="Password must be 3 char and max size 10 char !!")
	private String password;

	public UserDto() {

		super();

		// TODO Auto-generated constructor stub
	}
	public UserDto(int id, String name, String email,String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password=password;
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


}
