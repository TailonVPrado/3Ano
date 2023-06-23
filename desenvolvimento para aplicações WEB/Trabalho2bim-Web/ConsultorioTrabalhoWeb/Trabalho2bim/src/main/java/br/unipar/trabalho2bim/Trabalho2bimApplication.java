package br.unipar.trabalho2bim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Trabalho2bimApplication {

	public static void main(String[] args) {
		SpringApplication.run(Trabalho2bimApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(geraInfoSwagger())
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.unipar.trabalho2bim"))
				.paths(PathSelectors.any())
				.build();
	}
	public ApiInfo geraInfoSwagger() {
		return new ApiInfo("Documetação trabalho segundo bimestre (Desenvolvimento de Aplicações WEB)",
				"Tailon Prado (217364) e Larissa Lima (222046)",
				"1.0",
				null,
				"Tailon e Larissa",
				null,
				null);
	}


}
