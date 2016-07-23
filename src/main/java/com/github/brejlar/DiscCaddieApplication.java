package com.github.brejlar;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.github.brejlar")
public class DiscCaddieApplication {
	@Autowired
	private DataSource dataSource;

	@RequestMapping("/")
	public String hello() {
		return new JdbcTemplate(dataSource).queryForObject("select msg from messages where id=?", String.class, 1);
	}

	public static void main(String[] args) {
		SpringApplication.run(DiscCaddieApplication.class, args);
	}
}