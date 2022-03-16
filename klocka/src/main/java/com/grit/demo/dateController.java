package com.grit.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class dateController {

	@RequestMapping(
			value = "/date",
			method = { 
					RequestMethod.GET,
					RequestMethod.POST })
	public String date() {
		DateFormat dateFormat = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = new Date();
		
		return dateFormat.format(date);
	}

	@RequestMapping(
			value = "/datePerson",
			method = { 
					RequestMethod.GET,
					RequestMethod.POST })
	public String datePerson(
			@RequestParam String name) {
		DateFormat dateFormat = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = new Date();
		
		String pattern = "Hej %s, idag är det '%s'.";
		String output = String.format(pattern, name, dateFormat.format(date));
				
		return output;
	}
}
