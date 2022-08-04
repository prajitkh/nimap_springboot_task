package com.springbootproject.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;




@Embeddable
public class UserRoleId implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	private RoleEntity role;
	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	@Override
	public int hashCode() {

		return Objects.hash(role, user);

	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {

			return true;

		}

		if ((obj == null) || (getClass() != obj.getClass())) {

			return false;

		}

		UserRoleId other = (UserRoleId) obj;
		return Objects.equals(role, other.role) && Objects.equals(user, other.user);

	}

	public UserRoleId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRoleId(User user, RoleEntity role) {
		super();
		this.user = user;
		this.role = role;
	}

	
	
	
}
