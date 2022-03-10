package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class minController {

	@RequestMapping("/")
	public String hej() {
		return "hej" + " svejs";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(String siffra) {
		return "hej " + siffra;
	}

	@GetMapping(value = "/input")
	public String input(String siffra) {
		return "hej " + siffra;
	}

	@RequestMapping(path = { "/sten/person1", "/person1/sten" })
	public String sten1() {
		return "sten person 1";
	}

	@RequestMapping(
			path = "/img", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String img() {
		return "{ \"data\": \"value\" }";
	}
	

}
