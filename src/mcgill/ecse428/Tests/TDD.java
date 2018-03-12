/**
 * @author Karim El-Baba
 * I.D: 26058233
 */
package mcgill.ecse428.Tests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import mcgill.ecse428.PostalRateCalculator.*;

public class TDD {

	// Objects
	private PostalRateCalculator tester = new PostalRateCalculator();

	// Error Messages
	private final String INVALID_FROM_CODE = "Ivalid From Postal Code, please enter re-enter from postal code";
	private final String INVALID_TO_CODE = "Ivalid To Postal Code, please enter re-enter to postal code";
	private final String INVALID_WEIGHT = "Ivalid weight, please a number between 0g and 50g";
	private final String INVALID_LENGTH = "Ivalid length, please a number between 0cm to 200cm";
	private final String INVALID_HEIGHT = "Ivalid length, please a number between 0cm to 300cm";
	private final String INVALID_WIDTH = "Ivalid width, please a number between 0cm to 400cm";
	private final String INVALID_POSTAL_TYPE = "Ivalid postal type, please select between: Regular, Xpress, Prior";

	// Error Messages 2
	private final String INVALID_WEIGHT_2 = "Ivalid weight, please a number between 0g and 50g";
	private final String INVALID_LENGTH_2 = "Ivalid length, please a number between 201cm to 300cm";
	private final String INVALID_HEIGHT_2 = "Ivalid length, please a number between 0cm to 300cm";
	private final String INVALID_WIDTH_2 = "Ivalid width, please a number between 0cm to 400cm";

	// Used to sample console output and ensure valide error messages
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

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

		tester.validatePostalCode(inValidFromCode, validToCode);

		assertEquals(INVALID_FROM_CODE, outContent.toString());
	}

	// Test 25
	@Test
	public void invalidToPostalCode() {

		String inValidToCode = "h2q4j2";
		String validFromCode = "alskdjl";

		tester.validatePostalCode(validFromCode, inValidToCode);

		assertEquals(INVALID_FROM_CODE, outContent.toString());
	}

	@After
	public void restoreStreams() {
		System.setOut(System.out);
		System.setErr(System.err);
	}
}
