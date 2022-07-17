package com.clintonbeardsley.guitarpedalapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition (
	info = @Info (title = "Guitar Pedal API", version = "1.0"),
	servers = @Server (url = "/", description = "Default Server URL")
)
public class GuitarPedalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuitarPedalApiApplication.class, args);
	}

}