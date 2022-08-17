package com.springbootproject.entity;

public class AssignRole {

//	
//	private String email;
//	private String  roleName;
//	  
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getRoleName() {
//		return roleName;
//	}
//	public void setRoleName(String roleName) {
//		this.roleName = roleName;
//	}
//	public AssignRole(String email, String roleName) {
//		super();
//		this.email = email;
//		this.roleName = roleName;
//	}
//	public AssignRole() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
	
	
	
	private int roleId;
	private int userId;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public AssignRole(int roleId, int userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}
	public AssignRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
