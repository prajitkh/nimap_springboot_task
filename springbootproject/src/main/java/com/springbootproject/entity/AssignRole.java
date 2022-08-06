package com.springbootproject.entity;

public class AssignRole
{



	private int userId;
	private int roleId;
	public AssignRole(int userId, int roleId) {
		super();
		this.userId = userId;
		this.roleId = roleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public AssignRole() {
		super();
		// TODO Auto-generated constructor stub
	}

}
