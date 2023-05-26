package br.com.erudio.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@OpenAPIDefinition
@Configuration
public class OpenApiCOnfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("RESTful API with Java 18 and Spring Boot 3")
						.version("v1")
						.description("Some description about your API")
						.termsOfService("https://pub.erudio.com.br/meus-cursos")
						.license(
								new License()
										.name("Apache 2.0")
										.url("https://pub.erudio.com.br/meus-cursos")
						)
				);
	}

}
