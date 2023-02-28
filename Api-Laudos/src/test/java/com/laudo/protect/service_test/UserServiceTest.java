package com.laudo.protect.service_test;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.laudo.protect.controller.UserController;
import com.laudo.protect.model.User;
import com.laudo.protect.repository.dao.UserDao;
import com.laudo.protect.service.UserService;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserDao dao;
	
	@InjectMocks
	private UserService service;
	
	@Test
	public void cadastrarUser() {
		User u = new User("Teste", "1234", "manutencao");
		
		service.cadastrarUsuario(u);
		//User res = service.cadastrarUsuario(new User("Teste", "1234", "manutencao"));
		verify(dao, times(1)).save(u);
		
		
	}
	
	@Test
	public void VerificarUser() {
		
		User u = new User("Teste","1234" , null);
		User res = new User(1, "Teste", new BCryptPasswordEncoder().encode("1234"), "manutencao");
		when(dao.findByuser(u.getUser())).thenReturn(res);
		
		User s = service.verificarUsuario(u);
		
		Assertions.assertEquals("manutencao", s.getType());
		
		
	}
	
	@Test
	public void VerificarUserSenha() {
		
		User u = new User("Teste","123" , null);
		User res = new User(1, "Teste", new BCryptPasswordEncoder().encode("1234"), "manutencao");
		when(dao.findByuser(u.getUser())).thenReturn(res);
		
		User s = service.verificarUsuario(u);
		
		Assertions.assertEquals("Erro Login", s.getType());
		
		
	}
	
	@Test
	public void buscarUser(){
		String usuario = "Teste";
		User res = new User(1, "Teste", new BCryptPasswordEncoder().encode("1234"), "manutencao");
		
		when(dao.findByuser(usuario)).thenReturn(res);
		User s = service.buscarUser(usuario);
		
		Assertions.assertEquals(res, s);
		
		
		
		
	}
	

}
