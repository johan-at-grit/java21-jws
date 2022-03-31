package com.grit.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class calcController {

	@RequestMapping(
			value = "/",
			method = RequestMethod.GET)
	public String add(String s1, String s2) {
		int i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);

		int res = (new calcSvc()).add(i1, i2);
		
		String sRes = Integer.toString(res);
		
		String json = String.format(Constants.calcJsonPattern, sRes);
		
		
		return json;
	}
}
