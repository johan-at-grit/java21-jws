package com.grit.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hejController {

	@RequestMapping(
			path = "/",
			method = RequestMethod.GET)
	public String hej() {
		return "hej";
	}
	
	@RequestMapping(
			path = "/name",
			method = RequestMethod.GET)
	public String hejName(
			@RequestParam String name) {
		return "hej " + name;
	}
}
