package br.com.erudio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
@Bean
	public void testarSwagger() {
		System.out.println("teste");
	}
}
