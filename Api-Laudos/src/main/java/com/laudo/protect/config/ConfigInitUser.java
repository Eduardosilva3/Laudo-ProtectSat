package com.laudo.protect.config;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


import com.laudo.protect.model.User;
import com.laudo.protect.service.UserService;



@Component
public class ConfigInitUser {
	
	@Autowired
	private UserService service;
	
	@EventListener
	public void impprimir(ContextRefreshedEvent e) {
		
		User use = service.buscarUser("teste");
		if(use==null) {
			User newUser = new User("teste","12345","tecnico");
			User res = service.cadastrarUsuario(newUser);
			System.out.println("Usuario Padrão: "+res.getUser()+". De ID: "+res.getIdUser()+". Cadastrado com Sucesso.");
		}
	}
	
}
