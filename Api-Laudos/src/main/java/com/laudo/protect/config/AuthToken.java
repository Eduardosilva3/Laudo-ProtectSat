package com.laudo.protect.config;

import com.laudo.protect.dto.UserDTO;


public class AuthToken {
	
	private String token;
	private UserDTO user;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthToken(String token) {
		super();
		this.token = token;
	}

	public AuthToken() {
		super();
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
}