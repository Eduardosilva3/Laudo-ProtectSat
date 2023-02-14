package com.laudo.protect.repository.dao;

import org.springframework.data.repository.CrudRepository;

import com.laudo.protect.model.User;

public interface UserDao extends CrudRepository<User, Integer>{

	public User findByuser(String user);
}
