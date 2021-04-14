package com.camp.campApi;

import com.camp.campApi.logging.Log4jSQL;
import org.apache.logging.log4j.LogManager;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CampApiApplication {



	public static void main(String[] args) {
		org.slf4j.Logger logger = LoggerFactory.getLogger(CampApiApplication.class);
		logger.debug("Hello this is a debug message");
		logger.info("Hello this is an info message");
		SpringApplication.run(CampApiApplication.class, args);


	}


	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}


}


