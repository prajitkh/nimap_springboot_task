package com.springbootproject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE logger_entity SET is_active = false WHERE id=?")
@Entity
public class LoggerEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;

	@Column(name = "token", length = 512)
	private String token;

	@Column(name = "created_at")
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "expire_at")
	private Date expireAt;

	private boolean isActive =true;





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getToken() {
		return token;
	}





	public void setToken(String token) {
		this.token = token;
	}





	public Date getCreatedAt() {
		return createdAt;
	}





	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}





	public Date getExpireAt() {
		return expireAt;
	}





	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}





	public boolean isActive() {
		return isActive;
	}





	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}





	public LoggerEntity(int id, String token, Date createdAt, Date expireAt, boolean isActive) {
		super();
		this.id = id;
		this.token = token;
		this.createdAt = createdAt;
		this.expireAt = expireAt;
		this.isActive = isActive;
	}





	public LoggerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



}
