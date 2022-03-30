package com.grit.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mainController {

	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public String hej() {
		return "Hej!";
	}

	@RequestMapping(
			value = "/{name}",
			method = RequestMethod.GET)
	public String hej(@PathVariable String name) {
		String textFormat = "Hej, '%s'!";
		return String.format(textFormat, name);
	}
}
