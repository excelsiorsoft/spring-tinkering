package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("application-context.xml")
public class DbpollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbpollerApplication.class, args);
	}
}
