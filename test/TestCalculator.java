import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

public class TestCalculator {
	
	private Calculator testClass;
	
	@BeforeEach
	public void setUp() throws Exception {
		testClass = new Calculator();
	}

	@Test
	public void testAdd() {
		float result = 35 + 15;
		assertEquals(result, testClass.add(35, 15));
	}
	@Test
	public void testMultiply() {
		float result = 35 * 15;
		assertEquals(result, testClass.multiply(35, 15));
	}
	@Test
	public void testSubstract() {
		float result = 35 - 15;
		assertEquals(result, testClass.substract(35, 15));
	}
	@Test
	public void testDivite() {
		float result = 35 / (float)15;
		assertEquals(result, testClass.divide(35, 15));
	}
	@Test
	public void testDivisionByZero() throws Exception {
		try {
			testClass.divide(10, 0);
			fail("Cannot be divided by zero!");
		} catch (Exception e) {
			
		}
	}

}
