package com.laudo.protect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laudo.protect.config.AuthToken;
import com.laudo.protect.config.TokenUtil;
import com.laudo.protect.model.User;
import com.laudo.protect.service.UserService;

import springfox.documentation.spring.web.json.Json;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private TokenUtil token;
	
	
	@PostMapping("/user")
	public ResponseEntity<AuthToken> validarUsuario(@RequestBody User user){
		
		
		
		
		User res = service.verificarUsuario(user);
		
		
		
		
			return ResponseEntity.ok(token.encodeToken(res));
		
			
		
	}
	
	@PostMapping("/user/registrar")
	public ResponseEntity<User> registrar(@RequestBody User user){
		User res = service.cadastrarUsuario(user);
		
		if(res!=null) {
			return ResponseEntity.ok(res);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
}
