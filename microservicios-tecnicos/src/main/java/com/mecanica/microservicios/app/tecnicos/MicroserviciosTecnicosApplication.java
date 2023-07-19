package com.mecanica.microservicios.app.tecnicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.mecanica.microservicios.commons.tecnicos.models.entity"})
public class MicroserviciosTecnicosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosTecnicosApplication.class, args);
	}

}
