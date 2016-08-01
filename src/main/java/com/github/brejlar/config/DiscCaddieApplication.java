package com.github.brejlar.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.brejlar")
public class DiscCaddieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscCaddieApplication.class, args);
	}
	
}