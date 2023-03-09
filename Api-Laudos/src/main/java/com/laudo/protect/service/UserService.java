package com.laudo.protect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laudo.protect.dto.UserDTO;
import com.laudo.protect.dto.UserLoginDTO;
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
	
	public UserDTO verificarUsuario(UserLoginDTO user){
		
		User res = dao.findByuser(user.getUser());
		UserDTO userDto = new UserDTO();
		
		
		if(res!=null&& new BCryptPasswordEncoder().matches(user.getSenha(), res.getSenha()) ) {
			userDto.setType(res.getType());
			userDto.setUser(res.getUser());
			return userDto;
		}else{
			userDto.setType("Erro Login");
			return userDto;
		}
		
	}
	
	
	public User cadastrarUsuario(User user) {
		
		String HasshSenha = new  BCryptPasswordEncoder().encode(user.getSenha());
		
		user.setSenha(HasshSenha);
		
		return dao.save(user);
	}
	


}
