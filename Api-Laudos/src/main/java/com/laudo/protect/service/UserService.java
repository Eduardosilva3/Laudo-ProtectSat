package com.laudo.protect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laudo.protect.model.User;
import com.laudo.protect.repository.dao.UserDao;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User buscarUser(String user) {
		// TODO Auto-generated method stub
		
		
		return dao.findByuser(user);
	}
	
	public User verificarUsuario(User user){
		
		User res = dao.findByuser(user.getUser());
		
		
		
		if(res!=null&& new BCryptPasswordEncoder().matches(user.getSenha(), res.getSenha()) ) {
			return res;
		}else{
			user.setType("Erro Login");
			return user;
		}
		
	}
	
	
	public User cadastrarUsuario(User user) {
		
		String HasshSenha = new  BCryptPasswordEncoder().encode(user.getSenha());
		
		user.setSenha(HasshSenha);
		
		return dao.save(user);
	}
	


}
