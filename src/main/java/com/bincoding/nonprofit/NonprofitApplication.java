package com.bincoding.nonprofit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableSwagger2
public class NonprofitApplication {

	public static void main(String[] args) {
		SpringApplication.run(NonprofitApplication.class, args);
	}

}
