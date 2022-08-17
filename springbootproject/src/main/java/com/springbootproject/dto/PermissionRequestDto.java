package com.springbootproject.dto;



public class PermissionRequestDto {

	public String actionName;


	public String baseUrl;

	
	public String description;

	public String method;

	public String path;

	public int entityId;

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public PermissionRequestDto(String actionName, String baseUrl, String description, String method, String path,
			int entityId) {
		super();
		this.actionName = actionName;
		this.baseUrl = baseUrl;
		this.description = description;
		this.method = method;
		this.path = path;
		this.entityId = entityId;
	}

	public PermissionRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
