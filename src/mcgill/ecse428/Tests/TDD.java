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

	// Test 1
	@Test
	public void wieghtRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.3;
		double found_Rate = PostalRateCalculator.getRate(0.1, 0, 1);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 2
	@Test
	public void heightRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.4;
		double found_Rate = PostalRateCalculator.getRate(49, 2, 3);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 3
	@Test
	public void lengthRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double found_Rate = PostalRateCalculator.getRate(99, 4, 5);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 4
	@Test
	public void widthRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.9;
		double found_Rate = PostalRateCalculator.getRate(99, 6, 7);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 5
	@Test
	public void typeRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.5;
		double found_Rate = PostalRateCalculator.getTypeRate("Xpress");
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 6
	@Test
	public void toPostalCodeRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double found_Rate = PostalRateCalculator.getPostalCodeRate("A1A 1A1");
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 7
	@Test
	public void fullRateWeight1() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 50;
		double length = 100;
		double weight = 0.1;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 8
	@Test
	public void fullRateWeight2() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 50;
		double length = 100;
		double weight = 0.26;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 9
	@Test
	public void fullRateHeight1() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 0;
		double length = 100;
		double weight = 150;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 10
	@Test
	public void fullRateHeight2() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 140;
		double length = 100;
		double weight = 150;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 11
	@Test
	public void fullRateLength1() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 50;
		double length = 49;
		double weight = 150;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 12
	@Test
	public void fullRateLength2() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 50;
		double length = 130;
		double weight = 150;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 13
	@Test
	public void fullRateWidth1() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 25;
		double height = 50;
		double length = 100;
		double weight = 150;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 14
	@Test
	public void fullRateWidth2() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 75;
		double height = 50;
		double length = 100;
		double weight = 150;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 15
	@Test
	public void fullRateType1() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 50;
		double length = 100;
		double weight = 150;
		String type = "Xpress";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 16
	@Test
	public void fullRateToPostalCode1() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 50;
		double length = 100;
		double weight = 150;
		String type = "Regular";
		String to = "J3Q 1R9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 17
	@Test
	public void fullRateToPostalCode2() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double width = 50;
		double height = 50;
		double length = 100;
		double weight = 150;
		String type = "Regular";
		String to = "A5N 1W9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, 0);
	}

	// Test 18
	@Test
	public void inValidDimensionFormat() {
		String invalid = "S";
		double EXPECTED_VALUE = -1;
		double returned = PostalRateCalculator.validateDimensionFormat(invalid);
		assertEquals(EXPECTED_VALUE, returned, 0);
	}

	// Test 19
	@Test
	public void weightOutOfRange() throws FileNotFoundException {
		double EXPECTED_VALUE = -1;
		double found_Rate = PostalRateCalculator.getRate(1, 0, 1);
		assertEquals(EXPECTED_VALUE, found_Rate, 0);
	}

	// Test 20
	@Test
	public void heightOutOfRange() throws FileNotFoundException {
		double EXPECTED_VALUE = -1;
		double found_Rate = PostalRateCalculator.getRate(300, 0, 1);
		assertEquals(EXPECTED_VALUE, found_Rate, 0);

	}

	// Test 21
	@Test
	public void lengthOutOfRange() throws FileNotFoundException {
		double EXPECTED_VALUE = -1;
		double found_Rate = PostalRateCalculator.getRate(300, 2, 3);
		assertEquals(EXPECTED_VALUE, found_Rate, 0);

	}

	// Test 22
	@Test
	public void widthOutOfRange() throws FileNotFoundException {
		double EXPECTED_VALUE = -1;
		double found_Rate = PostalRateCalculator.getRate(300, 4, 5);
		assertEquals(EXPECTED_VALUE, found_Rate, 0);

	}

	// Test 23
	@Test
	public void invalidType() {
		double EXPECTED_VALUE = -1;
		String invalid = "Something Invalid";
		boolean found_Rate = PostalRateCalculator.validatePostalType("Something Invalid");
		assertFalse(found_Rate);

	}

	// Test 24
	@Test
	public void invalidFromPostalCode() {
		String inValidFromCode = "alskdjl";
		String validToCode = "h2q4j2";
		boolean result = PostalRateCalculator.validatePostalCode(inValidFromCode, validToCode);

		assertFalse(result);
	}

	// Test 25
	@Test
	public void invalidToPostalCode() {

		String inValidToCode = "h2q4j2";
		String validFromCode = "alskdjl";
		boolean result = PostalRateCalculator.validatePostalCode(validFromCode, inValidToCode);

		assertFalse(result);
	}

}
