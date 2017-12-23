/**
 * 
 */
package com.ragas.boot.rest;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author Chandra Jagarlamudi
 *
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket productApi() {
		Set<String> consumeAndProduces = new HashSet<>(Arrays.asList("Application/json","Application/XML"));
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
				.paths(regex("/"))
				.build()
				.apiInfo(metaData())
				.consumes(consumeAndProduces)
				.produces(consumeAndProduces);
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"Spring Boot REST API",
				"Spring Boot REST API for User management",
				"1.0",
				"Terms of service",
				new Contact("Chandra Jagarlamudi", "https://www.linkedin.com/in/chandra-jagarlamudi/", "chandra.jagarlamudi@gmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
		return apiInfo;
	}

}
