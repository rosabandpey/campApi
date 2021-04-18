package com.camp.campApi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CampApiApplication {



	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(CampApiApplication.class);
		logger.debug("Hello this is a debug message");
		logger.info("Hello this is an info message");
		logger.error("Error Message Logged !!!", new NullPointerException("NullError"));
		SpringApplication.run(CampApiApplication.class, args);


	}


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


}


