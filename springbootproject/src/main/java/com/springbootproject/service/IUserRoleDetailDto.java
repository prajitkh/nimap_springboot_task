package com.springbootproject.service;

import org.springframework.beans.factory.annotation.Value;

public interface IUserRoleDetailDto {
	@Value("#{target.pk.role.id}")
	public Long getId();

	@Value("#{target.pk.role.roleName}")
	public String getName();

	@Value("#{target.pk.role.isActive}")
	public Boolean getIsActive();

}
