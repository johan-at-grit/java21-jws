package com.grit.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calcController {

	@RequestMapping(
		value = "/calc/add/{val1}/{val2}",
		method = RequestMethod.GET)
	public String add(
		@PathVariable String val1, 
		@PathVariable String val2)
	{
		int v1 = Integer.parseInt(val1);
		int v2 = Integer.parseInt(val2);
		
		String result = Integer.toString(v1 + v2);
		
		return result;
	}

	@RequestMapping(
		value = "/calc/sub/{val1}/{val2}",
		method = RequestMethod.GET)
	public String sub(
		@PathVariable String val1, 
		@PathVariable String val2)
	{
		int v1 = Integer.parseInt(val1);
		int v2 = Integer.parseInt(val2);
			
		String result = Integer.toString(v1 - v2);
		
		return result;
	}
}
