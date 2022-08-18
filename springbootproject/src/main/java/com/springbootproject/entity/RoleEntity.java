package com.springbootproject.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Where(clause = "is_active= true")
@SQLDelete(sql = "UPDATE roles SET is_active = false WHERE id=?")
@Table(name = "roles")
@Entity
public class RoleEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "is_active")
	private boolean isActive=true;

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	private Date updatedAt;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "task.role", cascade = CascadeType.ALL)
@JsonIgnore
	private List<UserRoleEntity> userRole;


//	@ManyToMany(fetch = FetchType.LAZY)
//	//@JoinTable(name = "userInfo_roles", joinColumns = @JoinColumn(name = "u_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "r_id", referencedColumnName = "id"))
//	private List<User> user = new ArrayList<>();

	public RoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public List<UserRoleEntity> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRoleEntity> userRole) {
		this.userRole = userRole;
	}

	public RoleEntity(int id, String roleName, boolean isActive, Date createdAt, Date updatedAt,
			List<UserRoleEntity> userRole) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.userRole = userRole;
	}



//	public RoleEntity(int id, String roleName, boolean isActive, Date createdAt, Date updatedAt, List<User> user) {
//	super();
//	this.id = id;
//	this.roleName = roleName;
//	this.isActive = isActive;
//	this.createdAt = createdAt;
//	this.updatedAt = updatedAt;
//	this.user = user;
//}
//
//	public Collection<User> getUser() {
//		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}
//
//	
	

}

