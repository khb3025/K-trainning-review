package com.example.learningreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LearningreviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningreviewApplication.class, args);
	}

}
