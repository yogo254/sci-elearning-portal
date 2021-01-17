package com.yogo.scielearningportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SciElearningPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SciElearningPortalApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder getEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}
