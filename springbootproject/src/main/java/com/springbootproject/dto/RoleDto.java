package com.springbootproject.dto;

import java.util.List;

import com.springbootproject.entity.UserRoleEntity;

public class RoleDto  {

	private int id;
	private String roleName;



	private List<UserRoleEntity> userRole;

	public List<UserRoleEntity> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}

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
