package com.laudo.protect.config;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laudo.protect.dto.ErroDTO;
import com.laudo.protect.model.User;
import com.laudo.protect.service.UserService;

import io.jsonwebtoken.io.IOException;

public class MyFilter extends OncePerRequestFilter{

	@Autowired
	private UserService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException, JsonProcessingException, java.io.IOException {
		System.out.println("filtro");
		
		

		try {
			
			if(request.getHeader("authorization")!=null) {
				//recupero o cabeçaljo
				Authentication auth = TokenUtil.decodeToken(request);
				
				
				
				if(auth != null) {
					//se a requisição for valida passa para frente
					SecurityContextHolder.getContext().setAuthentication(auth);
					
				}
					
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			//token eciste, mas não é valido e customiza a mensagem de erro
			
			System.out.println(e.getMessage());
			
			ErroDTO erro = new ErroDTO(401, "autorização invalida");
			response.setStatus(erro.getStatus());
			response.setContentType("application/json");
			ObjectMapper mapper = new ObjectMapper();
			response.getWriter().print(mapper.writeValueAsString(erro));
			response.getWriter().flush();
			return;
		}
		
		
		
		filterChain.doFilter(request, response);
		
	}

}
