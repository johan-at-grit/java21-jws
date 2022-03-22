package com.example.demo;

public class helloService {

	public String hej() {
		return "Hej Elever ni är duktiga!";
	}

	private String hejDescription() {
		return "Metoden /Hej [GET] har ett statiskt hälsningsmeddelande, använder inga parameterar.";
	}

	public String hej2() {
		return "Hej Elever ni är mycket kluriga!";
	}

	private String hej2Description() {
		return "Metoden /Hej2 [GET] har ett statiskt hälsningsmeddelande, använder inga parameterar.";
	}
	
	public String Description() {
		return hejDescription() + "\r\n" 
				+ hej2Description() + "\r\n";
	}
}
