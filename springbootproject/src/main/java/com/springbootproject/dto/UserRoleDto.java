package com.springbootproject.dto;

public class UserRoleDto {
	private int id;
	private String name;
	private String roleName;
	public UserRoleDto(int id, String name, String roleName) {
		super();
		this.id = id;
		this.name = name;
		this.roleName = roleName;
	}
	public UserRoleDto() {
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
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
