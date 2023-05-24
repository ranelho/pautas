package com.rlti.actdigital;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "ACT Pautas", version = "1.0.0", description = "Gestão de Pautas"),
		servers = {@Server(url = "/act/api", description = "Default Server URL")})
@SpringBootApplication
public class ActDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActDigitalApplication.class, args);
	}

}
