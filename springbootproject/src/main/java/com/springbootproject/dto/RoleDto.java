package com.springbootproject.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class RoleDto {

	private int id;
	private String roleName;
	

	public RoleDto(String roleName) {
		super();
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleDto() {
		super();
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
