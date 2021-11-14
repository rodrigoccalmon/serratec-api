package org.serratec.backend.trabalhofinalapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("org.serratec.backend.trabalhofinalapi.controller"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
}
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Trabalho Final API")
				.description("Essa foi a API desenvolvida para o trabalho final pelo grupo 2: Rodrigo, Rafael, Raquel, Arthur\n\n"
						+ "Aconselhamos o seguinte passo a passo ao utilizar nossa API:\n"
						+ "1) Cadastrar primeiro uma categoria. \n"
						+ "2) Cadastrar um cliente. \n"
						+ "3) Cadastrar um pedido utilizandoo id do cliente cadastrado anteriormente: \n"
						+ "4) Cadastrar um produto utilizando o id do pedido e do cliente que foram cadastrados anteriormente. \n"
						+ "5) Não deixe de conferir os cadastros realizados no banco de dados h2 também para um maior entendimento :) ")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.termsOfServiceUrl("/service.html")
				.version("1.0.0")
				.build();
		return apiInfo;
	}
}