package com.example.demo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {

	private ArrayList<carsBean> cars = new ArrayList<carsBean>();
	
	@RequestMapping(
			value = "/observe",
			method = RequestMethod.GET)
	public String RegisterObservation(
			String Brand, 
			int Count) {
		
		carsBean oneCar = new carsBean();
		oneCar.setCount(Count);
		oneCar.setBrand(Brand);

		cars.add(oneCar);
		
		return "ok, registrerar observation för bilmodell " + Brand;
	}

	@RequestMapping(
			value = "/show",
			method = RequestMethod.GET)
	public String ShowObservations() {
		String result = "";

		for(var oneCar: cars) {
			result += "Bil: " + oneCar.getBrand() +
					"Antal: " + oneCar.getCount() +
					"   ";
		};
		
		return result;
	}

	@RequestMapping(
			value = "/showJson",
			method = RequestMethod.GET)
	public String ShowObservationsJson() {
		return ObjectsJson(cars);
	}

	@RequestMapping(
			value = "/observeVolvos",
			method = RequestMethod.GET)
	public String RegisterObservation(
			@RequestParam ArrayList<Integer> Count) {

		for(Integer oneCount: Count) {
			carsBean oneCar = new carsBean();
			oneCar.setBrand("Volvo");
			oneCar.setCount(oneCount);

			cars.add(oneCar);
		}
	
		return "ok, registrerar massor";
	}

	@RequestMapping(
			value = "/seen/{Brand}",
			method = RequestMethod.GET)
	public String Registerseen(@PathVariable String Brand) {
		
		carsBean oneCar = new carsBean();
		oneCar.setCount(1);
		oneCar.setBrand(Brand);

		cars.add(oneCar);
		
		return "ok, registrerar seen för bilmodell " + Brand;
	}

	private String ObjectJson(carsBean car) {
		return "{\"Brand\": \"" + car.getBrand() + "\"," +
				"\"Count\": " + car.getCount() + "}";
	}

	private String ObjectsJson(ArrayList<carsBean> cars) {
		
		String result = "";
		for(var oneCar: cars) {
			result += ObjectJson(oneCar) + ",";
		}
		
		if (result.length() > 2) {
			result = result.substring(0, result.length() - 1);			
		}
		
		result = "{ \"cars\": [" + result + "]}";
		
		return result;
	}
}
