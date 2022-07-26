package com.springbootproject.entity;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonGetter;





@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE user_role u SET is_active=false WHERE u.role_id=? AND  u.user_id=?")
@Entity
@Table(name = "user_role")
@AssociationOverrides({ @AssociationOverride(name = "task.user", joinColumns = @JoinColumn(name = "user_id")), @AssociationOverride(name = "task.role", joinColumns = @JoinColumn(name = "role_id")) })
public class UserRoleEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@CreationTimestamp
	private Date createAt;

	@UpdateTimestamp
	private Date updateAt;

	private boolean isActive=true;


	private UserRoleId task = new UserRoleId();


	public UserRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserRoleEntity(Date createAt, Date updateAt, boolean isActive, UserRoleId task) {
		super();
		this.createAt = createAt;
		this.updateAt = updateAt;
		this.isActive = isActive;
		this.task = task;
	}


	@Column(name = "created_at")
	@CreationTimestamp
	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Column(name = "updated_at")
	@UpdateTimestamp
	public Date getUpdateAt() {
		return updateAt;
	}


	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	@EmbeddedId
	public UserRoleId getTask() {
		return task;
	}


	@Column(name = "is_active")
	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setTask(UserRoleId task) {
		this.task = task;
	}






}
