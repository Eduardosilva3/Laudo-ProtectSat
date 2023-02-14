package com.laudo.protect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int idUser;
	
	@Column(name = "user")
	private String user;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "type")
	private String type;

	
	
	
	public User() {
		super();
	}

	public User(int idUser, String user, String senha, String type) {
		super();
		this.idUser = idUser;
		this.user = user;
		this.senha = senha;
		this.type = type;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
