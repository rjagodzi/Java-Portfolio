package isbntools;

import static org.junit.Assert.*;

import org.junit.Test;

public class ISBNTest {

	@Test
	public void isValidTenDigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449116");
		assertTrue("first value", result);
		result = validator.checkISBN("0140177396");
		assertTrue("second value", result);
	}
	
	@Test
	public void isThirteenDigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9780393341768");
		assertTrue("first value", result);
		result = validator.checkISBN("9798721052927");
		assertTrue("second value", result);
	}
	
	@Test
	public void TenDigitISBNnumbersEndingInAnXAreValid() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");
		assertTrue(result);
	}
	
	@Test
	public void isNotValidTenDigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0140449117");
		assertFalse(result);
	}
	
	@Test
	public void isNotValidThirteenDigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9798721052925");
		assertFalse(result);
	}
	
	@Test(expected = NumberFormatException.class)
	public void mustBeTenDigitISBN() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("123456789");
	}
	
	@Test(expected=NumberFormatException.class)
	public void onlyNumericISBN() {
		ValidateISBN validator = new ValidateISBN();
		validator.checkISBN("helloworld");
	}

}
