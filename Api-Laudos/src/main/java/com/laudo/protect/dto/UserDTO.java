package com.laudo.protect.dto;


public class UserDTO {
	
	private String user;
	private String Type;
	
	
	
	public UserDTO() {
		
	}
	public UserDTO(String user, String type) {
		super();
		this.user = user;
		Type = type;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	
	

}
