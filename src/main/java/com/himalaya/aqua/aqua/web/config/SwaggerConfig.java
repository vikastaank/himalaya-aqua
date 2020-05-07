package com.himalaya.aqua.aqua.web.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("AquapureAPI").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return regex("/api/*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Aquapure API").description("Aquapure API reference for developers")
				.termsOfServiceUrl("http://himalayarocare.com").contact("vikas.taank12@gmail.com")
				.license("Aquapure License").licenseUrl("vikas.taank12@gmail.com").version("1.0").build();
	}

}