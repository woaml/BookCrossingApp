package com.ana.bookcrossing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookcrossingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcrossingApplication.class, args);
	}

}
