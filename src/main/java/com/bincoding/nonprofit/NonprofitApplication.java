package com.bincoding.nonprofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class NonprofitApplication {
	public static void main(String[] args) {
		SpringApplication.run(NonprofitApplication.class, args);
	}
}
