package com.springbootproject.dto;

public class SuccessResponseDto {
	
	private String message;
	
	private String messgeKey;
	
	private Object data;

	public SuccessResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuccessResponseDto(String message, String messgeKey, Object data) {
		super();
		this.message = message;
		this.messgeKey = messgeKey;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessgeKey() {
		return messgeKey;
	}

	public void setMessgeKey(String messgeKey) {
		this.messgeKey = messgeKey;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	

}
