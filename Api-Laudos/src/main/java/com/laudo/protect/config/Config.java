package com.laudo.protect.config;


import java.util.Arrays;
import java.util.List;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config extends WebMvcConfigurationSupport {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.laudo.protect.controller"))
				.build()
				.apiInfo(metaData())
				
				/*.globalOperationParameters(Arrays.asList(
	                        new ParameterBuilder()
	                                .name("Authorization")
	                                .description("Header for JWT Token")
	                                .modelRef(new ModelRef("string"))
	                                .parameterType("header")
	                                .required(false)
	                                .build()))*/
				.securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
				.securityContexts(secutiryContext());

	}
	
	private List<SecurityContext> secutiryContext() {
		
		List<SecurityContext> list = Arrays.asList(SecurityContext.builder().securityReferences(defauthAuth()).forPaths(PathSelectors.ant("/ordem/**")).build(),
				SecurityContext.builder().securityReferences(defauthAuth()).forPaths(PathSelectors.ant("/etapa/**")).build(),
				SecurityContext.builder().securityReferences(defauthAuth()).forPaths(PathSelectors.ant("/user/registrar")).build());
		
		return list;
		
	}
	
	public List<SecurityReference> defauthAuth(){
		AuthorizationScope auth = new AuthorizationScope("ADMIN", "accesssEverything");
		 AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		 authorizationScopes[0] = auth;
		 
		 return Arrays.asList(
			        new SecurityReference("Token Access", authorizationScopes));
		
	}


	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Spring Boot REST API - Laudo")
				.description("\"API - Laudo\"")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.build();
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		
	}
	
	 @Override
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	            .allowedOrigins("http://localhost:4200","http://172.19.1.34","http://34.239.1.10")
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	        
	    }
	 
}
