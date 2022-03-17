package com.grit.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class hejControllerTest {
	
	private hejController sut;

	@Before
	public void setUp() throws Exception {
		sut = new hejController();		
	}

	@Test
	public void testHej() {
		String expected = "hej";
		String actual = sut.hej();
		
		assertTrue(actual.equals(expected));;
	}

	@Test
	public void testHejName() {
		String baseText = "hej";
		String baseTextWithSpace = baseText + " ";

		String testData = "Maria";
		String expected = baseTextWithSpace + testData;
		String notExpected = expected + " not match";
		
		String actual = sut.hejName(testData);
		
		assertTrue(actual.equals(expected));;
		assertFalse(actual.equals(notExpected));;
	}
}
