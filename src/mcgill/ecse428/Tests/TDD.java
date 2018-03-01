/**
 * @author Karim El-Baba
 * I.D: 26058233
 */
package mcgill.ecse428.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import mcgill.ecse428.PostalRateCalculator.*;

public class TDD {

	// Objects
	private PostalRateCalculator tester = new PostalRateCalculator();

	// Valid Rates
	private final double RATE_ONE = 10.25;
	private final double RATE_TWO = 20.50;
	// Error Messages
	private final String INVALID_FROM_CODE = "Ivalid From Postal Code, please enter re-enter from postal code:";
	private final String INVALID_TO_CODE = "Ivalid To Postal Code, please enter re-enter to postal code:";
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
	private final String INVALID_POSTAL_TYPE_2 = "Ivalid postal type, please select between: Regular, Xpress, Prior";
	
	@Test
	public void ValidInputsAndRate() throws FileNotFoundException {
		double rate = tester.getValidRate();
		assertEquals(RATE_ONE,rate,0.05);
		
	}

}
