package com.example.BD_RestApi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication (scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.BD_RestApi.repository")
public class BdRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BdRestApiApplication.class, args);
	}

}
