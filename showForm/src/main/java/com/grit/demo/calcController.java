package com.grit.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calcController {

	@RequestMapping(
			value = "/",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_HTML_VALUE
		)
	public String myForm() {
		String htmlForm = "<html><body><h1>POST på formulär<h1><form action=\"http://localhost:8080/calc\"  method=\"POST\">Värde 1: <input type=\"text\" name=\"val1\">Värde 2: <input type=\"text\" name=\"val2\"><input type=\"submit\" value=\"addera\"></form></body></html>";

		return htmlForm;
	}
	
	@RequestMapping(
			value = "/calc",
			method = RequestMethod.POST
		)
	public String add(String val1, String val2) {
		int v1 = Integer.parseInt(val1);
		int v2 = Integer.parseInt(val2);
		
		String result = Integer.toString(v1 + v2);
		return result;
	}
}
