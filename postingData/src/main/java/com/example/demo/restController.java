package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {

	private String firstName = "";
	private String lastName = "";
	
	@RequestMapping(
			value = "/save", 
			method = RequestMethod.POST)
	public String save(
			String firstName, 
			String lastName) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		
		return "Hej " + firstName + " " + lastName;
	}
}
