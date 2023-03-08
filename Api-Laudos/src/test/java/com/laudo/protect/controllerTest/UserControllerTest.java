package com.laudo.protect.controllerTest;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.event.annotation.PrepareTestInstance;

import com.laudo.protect.config.AuthToken;
import com.laudo.protect.config.MyFilter;
import com.laudo.protect.config.TokenUtil;
import com.laudo.protect.controller.UserController;
import com.laudo.protect.dto.UserDTO;
import com.laudo.protect.model.User;
import com.laudo.protect.service.UserService;

import antlr.Token;
 

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	
	@Mock
	private UserService service;
	
	@Mock
	private TokenUtil token;
	
	@InjectMocks
	private UserController controller;
	

	
	
       
  
	
	
	@Test
	public void registrarUsuario() {
		User res = new User(2, "Teste","1234","manutencao");
		User u = new User("Teste", "1234", "manutencao");
		User uError = new User("Teste", "12345", "manutencao");
		
		
		when(service.cadastrarUsuario(u)).thenReturn(res);
		
		ResponseEntity<User> s = controller.registrar(u);
		
		ResponseEntity<User> resError = controller.registrar(uError);
		
		Assertions.assertEquals(200,s.getStatusCodeValue());
		Assertions.assertEquals(res, s.getBody());
		Assertions.assertEquals(400, resError.getStatusCodeValue());
		
	}
	
	
	@Test
	public void validarUsuarioValido() {
		User body = new User("Teste", "1234", null);
		User res = new User(2, "Teste","1234","manutencao");
		
		lenient().when(service.verificarUsuario(body)).thenReturn(res);
		
		UserDTO dto = new UserDTO(res.getUser(), res.getType());
		
		
		
		
		
		
	  
	    
	    
	    
		
		ResponseEntity<AuthToken> response = controller.validarUsuario(body); 
		
		
		
		Assertions.assertEquals(200, response.getStatusCodeValue());
		Assertions.assertEquals("manutencao", response.getBody().getUser().getType());
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		request.addHeader("Authorization", response.getBody().getToken());
		
		
		
		Assertions.assertEquals( new UsernamePasswordAuthenticationToken(res.getUser(), res.getType(), Collections.emptyList()), TokenUtil.decodeToken(request));
		
		
		
		
		
		
	}
	
	@Test
	public void validarUsuarioInvalido() {
		
		User body = new User("Teste", "1234", null);
		User res = new User("Teste","1234","Erro Login");
		
		lenient().when(service.verificarUsuario(body)).thenReturn(res);
		
		
		
		
		
		
		
		
	  
	    
	    
	    
		
		ResponseEntity<AuthToken> response = controller.validarUsuario(body); 
		
		
		
		Assertions.assertEquals(200, response.getStatusCodeValue());
		Assertions.assertEquals("401", response.getBody().getToken());
		Assertions.assertEquals("Erro Login", response.getBody().getUser().getType());
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		request.addHeader("Authorization", response.getBody().getToken());
		
		Assertions.assertThrows(Exception.class, () -> TokenUtil.decodeToken(request));
		
		MockHttpServletRequest requestInvalid = new MockHttpServletRequest();
		requestInvalid.addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0ZSIsImF1ZCI6Im1hbnV0ZW5jYW8iLCJpc3MiOiJFZHVEZXYiLCJleHAiOjE2Nzc1NDg5Mjd9.fvU32r5scZp5A43slW5RNuIPuLBWxNUCXt37LSgVHqg");
		
		Assertions.assertThrows(Exception.class, () -> TokenUtil.decodeToken(requestInvalid));
		
	
		
	}
	
	
		
	
	
	
	
}
