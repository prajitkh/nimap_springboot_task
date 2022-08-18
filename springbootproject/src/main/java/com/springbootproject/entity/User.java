package com.springbootproject.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE users SET is_active = false WHERE id=?")
@Entity
@Table(name = "users")
public class User implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String name;

	@Column(name = "email",  unique = true)
	private String email;

	private boolean isActive =true;


	private String password;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "task.user", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<UserRoleEntity> userRole;


	//	@ManyToMany(fetch = FetchType.LAZY)
	//	@JoinTable(name = "userInfo_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	//	private List<RoleEntity> roles = new ArrayList<>();





	public User() {
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;

	}



	//	public Collection<RoleEntity> getRoles() {
	//		return roles;
	//	}
	//
	//
	//
	//	public void setRoles(List<RoleEntity> roles) {
	//		this.roles = roles;
	//	}



	//	public User(int id, String name, String email, boolean isActive, String password, List<RoleEntity> roles) {
	//		super();
	//		this.id = id;
	//		this.name = name;
	//		this.email = email;
	//		this.isActive = isActive;
	//		this.password = password;
	//		this.roles = roles;
	//	}
	//
	//
	//
	//	@Override
	//	public String toString() {
	//		return "User [id=" + id + ", name=" + name + ", email=" + email + ", isActive=" + isActive + ", password="
	//				+ password + ", roles=" + roles + "]";
	//	}


	public List<UserRoleEntity> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
	}



	public User(int id, String name, String email, boolean isActive, String password, List<UserRoleEntity> userRole) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.isActive = isActive;
		this.password = password;
		this.userRole = userRole;
	}















}