package com.example.learn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

public class InterviewApplication {

	private static final Logger logger = LogManager.getLogger(InterviewApplication.class);

	public static void main(String[] args) {
		logger.info("Application starting");
		SpringApplication.run(InterviewApplication.class, args);
	}

}
