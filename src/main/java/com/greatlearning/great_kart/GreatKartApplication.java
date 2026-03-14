package com.greatlearning.great_kart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.greatlearning.great_kart")
//@EnableAutoConfiguration
public class GreatKartApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreatKartApplication.class, args);
	}

}
