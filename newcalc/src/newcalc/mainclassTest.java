package newcalc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class mainclassTest {

	private mainclass sut;
	
	@Before
	public void setUp() {
		sut = new mainclass();
	}
	
	@Test
	public void testTestableAddSucess() {
		int actual = sut.testableAdd(5, 6);
		int expected = 11;
		
		assertEquals(actual, expected); 
	}

	@Test
	public void testTestableAddFail() {
		int actual = sut.testableAdd(5, 6);
		int expected = 121;
		
		assertNotEquals(actual, expected); 
	}

}
