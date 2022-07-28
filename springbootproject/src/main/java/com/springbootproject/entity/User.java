package com.springbootproject.entity;




import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Where(clause = "is_active=true")
@SQLDelete(sql = "UPDATE users SET is_active = false WHERE id=?")
@Entity
@Table(name = "users")
public class User implements UserDetails   {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	
	private String name;

	private String email;
	
	private boolean isActive =true;
	
	private String password;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public User(int id, String name, String email, boolean isActive, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.isActive = isActive;
		this.password = password;
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



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return null;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}





}