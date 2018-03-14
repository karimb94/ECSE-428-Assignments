/**
 * @author Karim El-Baba
 * I.D: 260582332
 */
package mcgill.ecse428.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import mcgill.ecse428.PostalRateCalculator.*;

public class TDD {

	double errorMargin = 0.000001;

	// Test 1
	@Test
	public void getDimensionSubRateTest() throws FileNotFoundException {
		double EXPECTED_RATE = 0.3;
		double weight = 0.1;
		double found_Rate = PostalRateCalculator.getRate(weight, 0, 1);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 2
	@Test
	public void typeRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.5;
		String type = "Xpress";
		double found_Rate = PostalRateCalculator.getTypeRate(type);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 3
	@Test
	public void toPostalCodeRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		String postal = "A1A 1A1";
		double found_Rate = PostalRateCalculator.getPostalCodeRate(postal);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 4
	@Test
	public void baseFullRateTest() throws FileNotFoundException {
		double EXPECTED_RATE = 2.4;
		double width = 49;
		double height = 49;
		double length = 49;
		double weight = 0.1;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 5
	@Test
	public void fullRateWeightChange() throws FileNotFoundException {
		double EXPECTED_RATE = 2.6;
		double width = 49;
		double height = 49;
		double length = 49;
		double weight = 0.26;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 6
	@Test
	public void fullRateHeightChange() throws FileNotFoundException {
		double EXPECTED_RATE = 2.8;
		double width = 49;
		double height = 99;
		double length = 49;
		double weight = 0.26;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 7
	@Test
	public void fullRateLengthChange() throws FileNotFoundException {
		double EXPECTED_RATE = 3.2;
		double width = 49;
		double height = 140;
		double length = 99;
		double weight = 0.26;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 8
	@Test
	public void fullRateWidthChange() throws FileNotFoundException {
		double EXPECTED_RATE = 3.5;
		double width = 99;
		double height = 140;
		double length = 140;
		double weight = 0.26;
		String type = "Regular";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 9
	@Test
	public void fullRateTypeChange() throws FileNotFoundException {
		double EXPECTED_RATE = 3.8;
		double width = 140;
		double height = 140;
		double length = 140;
		double weight = 0.26;
		String type = "Xpress";
		String to = "H3Z 1J9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 10
	@Test
	public void fullRateToPostalCodeChange() throws FileNotFoundException {
		double EXPECTED_RATE = 3.8;
		double width = 140;
		double height = 140;
		double length = 140;
		double weight = 0.26;
		String type = "Regular";
		String to = "J3Q 1R9";
		double found_Rate = PostalRateCalculator.getFullRate(width, height, length, weight, type, to);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	// Test 11
	@Test
	public void inValidDimensionFormat() {
		String invalid = "S";
		double EXPECTED_VALUE = -1;
		double returned = PostalRateCalculator.validateDimensionFormat(invalid);
		assertEquals(EXPECTED_VALUE, returned, errorMargin);
	}

	// Test 12
	@Test
	public void weightOutOfRange() throws FileNotFoundException {
		double EXPECTED_VALUE = -1;
		double found_Rate = PostalRateCalculator.getRate(1, 0, 1);
		assertEquals(EXPECTED_VALUE, found_Rate, errorMargin);
	}

	// Test 13
	@Test
	public void heightOutOfRange() throws FileNotFoundException {
		double EXPECTED_VALUE = -1;
		double found_Rate = PostalRateCalculator.getRate(300, 0, 1);
		assertEquals(EXPECTED_VALUE, found_Rate, errorMargin);

	}

	// Test 14
	@Test
	public void lengthOutOfRange() throws FileNotFoundException {
		double EXPECTED_VALUE = -1;
		double found_Rate = PostalRateCalculator.getRate(300, 2, 3);
		assertEquals(EXPECTED_VALUE, found_Rate, errorMargin);
	}

	// Test 15
	@Test
	public void widthOutOfRange() throws FileNotFoundException {
		double EXPECTED_VALUE = -1;
		double found_Rate = PostalRateCalculator.getRate(300, 4, 5);
		assertEquals(EXPECTED_VALUE, found_Rate, errorMargin);
	}

	// Test 16
	@Test
	public void invalidType() {
		String invalid = "Something Invalid";
		boolean found_Rate = PostalRateCalculator.validatePostalType(invalid);
		assertFalse(found_Rate);
	}

	// Test 17
	@Test
	public void invalidFromPostalCode() {
		String inValidFromCode = "alskdjl";
		String validToCode = "h2q4j2";
		boolean result = PostalRateCalculator.validatePostalCode(inValidFromCode, validToCode);
		assertFalse(result);
	}

	// Test 18
	@Test
	public void invalidToPostalCode() {
		String inValidToCode = "adq4j2";
		String validFromCode = "h3z1j9";
		boolean result = PostalRateCalculator.validatePostalCode(validFromCode, inValidToCode);
		assertFalse(result);
	}

	// Test 19
	@Test
	public void negativeDimensions() {
		String invalid = "-2";
		double EXPECTED_VALUE = -1;
		double returned = PostalRateCalculator.validateDimensionFormat(invalid);
		assertEquals(EXPECTED_VALUE, returned, errorMargin);
	}
}
