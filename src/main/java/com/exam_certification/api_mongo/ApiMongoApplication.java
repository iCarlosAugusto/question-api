package com.exam_certification.api_mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiMongoApplication.class, args);
	}

}
