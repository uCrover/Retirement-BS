package com.bootcamp.retirement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class RetirementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetirementServiceApplication.class, args);
	}

}
