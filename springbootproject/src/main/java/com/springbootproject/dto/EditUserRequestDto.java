package com.springbootproject.dto;




public class EditUserRequestDto   extends UserDto{

	private int roles;

	public EditUserRequestDto(int roles) {
		super();
		this.roles = roles;
	}

	public int  getRoles() {
		return roles;
	}

	public void setRoles(int  roles) {
		this.roles = roles;
	}
	
	
	public EditUserRequestDto() {
		super();
		
	}

	


	
	
	
	
}
