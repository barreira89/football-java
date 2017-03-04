package com.stevebarreira.football.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan({"com.stevebarreira.football.service","com.stevebarreira.football.service.impl", "com.stevebarreira.football.controller", "com.stevebarreira.football.application"})
@EnableMongoRepositories("com.stevebarreira.football.repository")
@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
