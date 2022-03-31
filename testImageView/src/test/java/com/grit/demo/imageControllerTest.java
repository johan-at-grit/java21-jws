package com.grit.demo;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class imageControllerTest {

	@Test
	public void test() throws IOException {
		// http://jubin.tech/articles/2018/12/05/Detect-image-format-using-java.html
		byte[] jpgHeader = new byte[] {(byte) 0xEF, (byte)0xBF, (byte)0xBD};

		var img = httpHelper.UrlResponse("http://localhost:8080/", "GET", null);
		byte[] imgBytes = img.getBytes();

		int i = 0;		
		for (byte b : jpgHeader) {
			if (imgBytes[i++] != b)
				assertTrue(false);
		}
		
		assertTrue(true);
	}
}
