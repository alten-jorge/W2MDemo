package com.w2m.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@SpringBootApplication
@EnableJpaRepositories
public class World2MeetApplication {

	public static void main(String[] args) {
		SpringApplication.run(World2MeetApplication.class, args);
	}

}
