package com.github.brejlar.controllers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final String PATH = "/users";

	@Autowired
	private DataSource dataSource;

	@RequestMapping(PATH)
	public String users() {
		return "Users page";
	}

}
