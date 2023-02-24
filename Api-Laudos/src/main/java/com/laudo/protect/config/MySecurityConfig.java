package com.laudo.protect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
@Configuration
public class MySecurityConfig {
	
	@Bean
	SecurityFilterChain securittyFilterChain(HttpSecurity http) throws Exception {
		System.out.println("configuracao");
		http.csrf().disable()  //desabilida o csrf
		.authorizeHttpRequests()
		.antMatchers(HttpMethod.POST, "/user").permitAll()
		.anyRequest().authenticated().and().cors();
		
		/*.requestMatchers(HttpMethod.GET, "/free").permitAll()
		.requestMatchers(HttpMethod.POST, "/login").permitAll()
		.requestMatchers(HttpMethod.GET, "/a").hasRole("tecnico")
		.anyRequest().authenticated().and().cors();*/
		
		http.addFilterBefore(new MyFilter(), UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
}
