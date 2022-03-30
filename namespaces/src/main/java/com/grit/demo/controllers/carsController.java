package com.grit.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grit.demo.beans.carsBean;

@RestController
public class carsController {
	private carsBean cars = new carsBean();
	
	public carsController() {
		this.cars.setBrand("Volvo");
		this.cars.setCount(4);
	}

	@RequestMapping(
			value = "cars/show",
			method = RequestMethod.GET)
	public String showCars() {
		String pattern = "Jag har sett %s bilar av typen %s.";
		return String.format(
				pattern, 
				this.cars.getCount(), 
				this.cars.getBrand());
	}	
}
