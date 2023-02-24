package com.laudo.protect.config;

import com.laudo.protect.model.User;

public class AuthToken {
	
	private String token;
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}