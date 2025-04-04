package com.droipup.races_microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RacesMicroservicesApplication {

	public static void main(String[] args) {


		System.out.println("Iniciando aplicación en el puerto: " + System.getenv("PORT")); // Debug
		SpringApplication.run(RacesMicroservicesApplication.class, args);
	}

}
