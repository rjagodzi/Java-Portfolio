package com.premiereManager.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.premiereManager.springboot.web")
public class PremiereManagerApp {

	public static void main(String[] args) {
		SpringApplication.run(PremiereManagerApp.class, args);
	}
}
