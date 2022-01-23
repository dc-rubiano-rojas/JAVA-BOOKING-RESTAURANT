package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class BookingRestaurantApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingRestaurantApiApplication.class, args);
		System.out.println("HOLA MUNDO");
	}

}
