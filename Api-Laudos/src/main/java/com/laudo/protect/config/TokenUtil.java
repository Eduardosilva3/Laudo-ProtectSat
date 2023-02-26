package com.laudo.protect.config;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import com.laudo.protect.model.User;
import com.laudo.protect.repository.dao.UserDao;
import com.laudo.protect.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.security.Keys;

@Component
public class TokenUtil {
	
	
	//Algumas constantes utilitarias
	private static final String EMISSOR = "EduDev";
	private static final String TOKEN_HEADER = "Bearer ";
	private static final String TOKEN_KEY = "858491499e7825p4133263g23w716882";
	private static final long UM_SEGUNDO = 1000;
	private static final long UM_MINUTO = 60*UM_SEGUNDO;
	private static final long CINCO_MINUTO = UM_MINUTO*5;
	private static final long VINTE_MINUTO = CINCO_MINUTO*4;
	
	//CODIFICADO DO TOKEN
	public AuthToken encodeToken(User u) {
		Key secretKey = Keys.hmacShaKeyFor(TOKEN_KEY.getBytes());
		
		if(u.getType()!="Erro Login") {
			
			String tokenJWT = Jwts.builder().setSubject(u.getUser())
					.setAudience(u.getType())
					.setIssuer(EMISSOR)
					.setExpiration(new Date(System.currentTimeMillis() + VINTE_MINUTO))
					.signWith(secretKey, SignatureAlgorithm.HS256)
					.compact();

					AuthToken token = new AuthToken(TOKEN_HEADER + tokenJWT);
					token.setUser(u);
					return token;
			
		}else {
			AuthToken token =  new AuthToken("401");
			token.setUser(u);
			return token;
		}
		
		
		
		
		
		
	}

	public static Authentication decodeToken(HttpServletRequest request) {
		
		
		
		System.out.println("Token");
		
		String jwtToken = request.getHeader("Authorization");
		jwtToken = jwtToken.replace(TOKEN_HEADER, "");
		
		//vou fazer a leitura do token
		Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(TOKEN_KEY.getBytes()).build().parseClaimsJws(jwtToken);

		//comelando a extrair as informaçoes
		String usuario = jwsClaims.getBody().getSubject();
		String emissor = jwsClaims.getBody().getIssuer();
		String type = jwsClaims.getBody().getAudience();
		Date validade = jwsClaims.getBody().getExpiration();
		
		
		
		
		if(usuario.length()!=0  && emissor.equals(EMISSOR) && type.length() !=0 && validade.after(new Date(System.currentTimeMillis()))) {
		    //Caso a requisição tenha o cabeçalho correto eu gero um token interno com as informçaões relevantes
			//return new UsernamePasswordAuthenticationToken("user", null,Collections.emptyList());
			return new UsernamePasswordAuthenticationToken(usuario, type, Collections.emptyList());
			
		}
		
		
		return null;
	}
	
	
}