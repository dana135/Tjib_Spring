package com.tjib.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * This application is the server side of Tjib, a show tickets purchase app.
 * Implementing a RESTful API and mapping data with JPA.
 * This is the initial class, application starts from here.
 */

@SpringBootApplication
public class TjibApplication {

	//run as spring boot application
	public static void main(String[] args) {
		SpringApplication.run(TjibApplication.class, args);
	}

}
