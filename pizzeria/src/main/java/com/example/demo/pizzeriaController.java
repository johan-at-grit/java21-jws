package com.example.demo;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class pizzeriaController {

	private ArrayList<pizzaBean> allOrders = new ArrayList<pizzaBean>();

	@RequestMapping(value = "/placeorder", method = RequestMethod.POST)
	public String placeOrder(@RequestParam String name, @RequestParam String size) {

		pizzaBean.Size mySize;

		switch (size) {
		case "normal":
			mySize = pizzaBean.Size.Normal;
			break;
		case "barn":
			mySize = pizzaBean.Size.Child;
			break;
		case "familj":
			mySize = pizzaBean.Size.Family;
			break;
		default:
			mySize = pizzaBean.Size.Normal;
			break;
		}

		pizzaBean myOrder = new pizzaBean(name, mySize);
		allOrders.add(myOrder);

		return "Tack för din beställning av " + myOrder.toString();
	}

	@RequestMapping(
			value = "/showorders",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String showOrders() {
		String result = "";
		int sum = 0;

		for (var order : this.allOrders) {
			result += order.toJsonString() + ",";
			sum += order.getPrice();
		}
		
		if (result.length() > 2) {
			result = result.substring(0, result.length() - 1);			
		}
		
		result = "{ \"order\":  [" + result + "], \"summa\": " + sum + " }";

		return result;
	}
}
