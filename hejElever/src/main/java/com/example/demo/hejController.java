package com.example.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hejController {
	
	@RequestMapping("/")
	public String hej() {
		return "Hej Elever ni är duktiga!";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/no2")
	public String hej2() {
		System.out.println("nu kör vi!");
		return "Hej Elever ni är mycket kluriga!";
	}

	@GetMapping("/vem")
	public String hejVem(String Who) {
		return "Hej " + Who + ", vem är du?";
	}

	@RequestMapping(path = "/img", produces = MediaType.IMAGE_JPEG_VALUE)
	public void img(HttpServletResponse response) throws IOException {
		System.out.println("visar en bild!");
		
		var imgFile = new ClassPathResource("blueberry.jpg");
		
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}
}
