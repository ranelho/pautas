package com.rlti.pautas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Gestão de Pautas", version = "1.0.0", description = "Gestão de Pautas"),
		servers = {@Server(url = "/pauta/api", description = "Default Server URL")})
@SpringBootApplication
public class PautasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PautasApplication.class, args);
	}

}
