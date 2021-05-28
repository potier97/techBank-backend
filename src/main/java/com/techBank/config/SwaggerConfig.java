package com.techBank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.techBank.controller")) 
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Bank Api Example")
				.description("Este es un ejemplo de api para un banco")
				.version("V0.1")
				.contact(new Contact("Nicolás Potier", "nipoanz.com", "nicolaspotier97@gmail.com"))
				.termsOfServiceUrl("https://example.terms") 
				.license("MIT") 
				.build();
	}
	
	
}
