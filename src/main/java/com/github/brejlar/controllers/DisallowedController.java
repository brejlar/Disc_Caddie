package com.github.brejlar.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisallowedController {

	private final String PATH = "/disallowed";

	@RequestMapping(PATH)
	public String discs() {
		return "Nope";
	}

}
