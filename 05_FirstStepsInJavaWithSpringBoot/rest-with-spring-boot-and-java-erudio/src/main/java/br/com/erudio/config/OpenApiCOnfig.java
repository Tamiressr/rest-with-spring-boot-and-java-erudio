package br.com.erudio.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiCOnfig {

	 @Bean
	 OpenAPI customOpenApi() {
		 
		 return new OpenAPI() .info(new Info()
	  .title("Restful API Java 18 Spring Boot 3").version("v1")
	  .description("description about the API").termsOfService("tt").license(new
	  License().name("Apache 2.0").url("ttt"))); }


}
