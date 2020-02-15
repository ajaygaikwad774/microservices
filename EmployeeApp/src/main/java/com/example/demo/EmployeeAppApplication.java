package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EmployeeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAppApplication.class, args);
	}

}
