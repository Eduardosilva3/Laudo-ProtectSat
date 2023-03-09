package com.laudo.protect.dto;

public class UserLoginDTO {

	private String user;
	private String senha;
	
	
	public UserLoginDTO(String user, String senha) {
		
		this.user = user;
		this.senha = senha;
	}

	

	public UserLoginDTO() {
		
	}



	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
