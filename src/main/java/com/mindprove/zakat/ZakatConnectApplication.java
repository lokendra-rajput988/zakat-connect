package com.mindprove.zakat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class ZakatConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZakatConnectApplication.class, args);
	}

}
