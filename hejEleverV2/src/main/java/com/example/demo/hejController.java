package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hejController {
	private helloService hs = new helloService();
	
	@CrossOrigin
	@RequestMapping("/")
	public String root() {
		return hs.Description();
	}

	@CrossOrigin
	@RequestMapping("/hej")
	public String hej() {
		return hs.hej();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, path = "/no2")
	public String hej2() {
		System.out.println("nu kör vi!");
		return "Hej Elever ni är mycket kluriga!";
	}

	@CrossOrigin
	@GetMapping("/vem")
	public String hejVem(String Who) {
		return "Hej " + Who + ", vem är du?";
	}

	@CrossOrigin
	@RequestMapping(path = "/img", produces = MediaType.IMAGE_JPEG_VALUE)
	public void img(HttpServletResponse response) throws IOException {
		System.out.println("visar en bild!");
		
		var imgFile = new ClassPathResource("blueberry.jpg");
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}

	@CrossOrigin
	@RequestMapping(value = "/posta", method = RequestMethod.POST)
	public String PostMapA() {
		System.out.println("här-A");
		return "Hej-A";
	}

	@CrossOrigin
	@RequestMapping(value = "/postr", method = RequestMethod.POST)
	public String PostMapping(@RequestParam String fname, @RequestParam String lname) {
		System.out.println("här");
		return "Hej " + fname + " " + lname;
	}
}
