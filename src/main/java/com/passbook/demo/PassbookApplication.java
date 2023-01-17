package com.passbook.demo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log4j2
public class PassbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PassbookApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
		return args -> {
			log.info("=====================  Application started =====================");
		};
	}

}
