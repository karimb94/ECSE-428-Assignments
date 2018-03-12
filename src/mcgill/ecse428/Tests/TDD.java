/**
 * @author Karim El-Baba
 * I.D: 26058233
 */
package mcgill.ecse428.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;
import mcgill.ecse428.PostalRateCalculator.*;

public class TDD {

	// Objects
	private PostalRateCalculator tester = new PostalRateCalculator();

	// Test 1
	@Test
	public void wieghtRate1() {
	}

	// Test 2
	@Test
	public void wieghtRate2() {
	}

	// Test 3
	@Test
	public void hieghtRate1() {
	}

	// Test 4
	@Test
	public void hieghtRate2() {
	}

	// Test 5
	@Test
	public void lengthRate1() {
	}

	// Test 6
	@Test
	public void lengthRate2() {
	}

	// Test 7
	@Test
	public void widthRate1() {
	}

	// Test 8
	@Test
	public void widthRate2() {
	}

	// Test 9
	@Test
	public void typeRate1() {
	}

	// Test 10
	@Test
	public void typeRate2() {
	}

	// Test 11
	@Test
	public void toPostalCodeRate1() {
	}

	// Test 12
	@Test
	public void toPostalCodeRate2() {
	}

	// Test 13
	@Test
	public void fromPostalCodeRate1() {
	}

	// Test 14
	@Test
	public void fromPostalCodeRate2() {
	}

	// Test 15
	@Test
	public void invalideWeight() {
	}

	// Test 16
	@Test
	public void weightOutOfRange() {
	}

	// Test 17
	@Test
	public void invalideHeight() {

	}

	// Test 18
	@Test
	public void heightOutOfRange() {

	}

	// Test 19
	@Test
	public void invalidWidthRange() {

	}

	// Test 20
	@Test
	public void widthOutOfRange() {

	}

	// Test 21
	@Test
	public void invalidLength() {

	}

	// Test 22
	@Test
	public void lengthOutOfRange() {

	}

	// Test 23
	@Test
	public void invalidType() {

	}

	// Test 24
	@Test
	public void invalidFromPostalCode() {
		String inValidFromCode = "alskdjl";
		String validToCode = "h2q4j2";
		boolean result = tester.validatePostalCode(inValidFromCode, validToCode);

		assertFalse(result);
	}

	// Test 25
	@Test
	public void invalidToPostalCode() {

		String inValidToCode = "h2q4j2";
		String validFromCode = "alskdjl";
		boolean result = tester.validatePostalCode(validFromCode, inValidToCode);

		assertFalse(result);
	}

}
