package com.springbootproject.entity;

public class AssignPermission {

	private int roleId;
	private int perId;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPerId() {
		return perId;
	}
	public void setPerId(int perId) {
		this.perId = perId;
	}
	public AssignPermission(int roleId, int perId) {
		super();
		this.roleId = roleId;
		this.perId = perId;
	}
	public AssignPermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
