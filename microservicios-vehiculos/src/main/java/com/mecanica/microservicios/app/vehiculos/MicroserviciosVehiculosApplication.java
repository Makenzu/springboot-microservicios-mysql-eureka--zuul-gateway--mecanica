package com.mecanica.microservicios.app.vehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.mecanica.microservicios.commons.tecnicos.models.entity",
			 "com.mecanica.microservicios.app.vehiculos.models.entity"})
public class MicroserviciosVehiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosVehiculosApplication.class, args);
	}

}
