package com.ch.croptohome.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Scope;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.ch.croptohome")
@EnableSwagger2
@EnableJpaRepositories(basePackages = {"com.ch.croptohome.repo"})
@EntityScan(basePackages = {"com.ch.croptohome.model"})

public class LaunchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaunchApplication.class, args);
	}
	@Bean
	
	public ApiSelectorBuilder saggerapi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ch.croptohome.controller"));
	}

}
