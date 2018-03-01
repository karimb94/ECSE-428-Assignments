/**
 * @author Karim El-Baba
 */
package mcgill.ecse428.Tests;

import static org.junit.Assert.*;
import org.junit.Test;
import mcgill.ecse428.PostalRateCalculator.*;

public class TDD {

	// Objects
	private PostalRateCalculator tester = new PostalRateCalculator();

	// Valid Rates
	private final double rateOne = 10.25;
	private final double rateTwo = 20.50;

	// Error Messages
	private final String INVALID_FROM_CODE = "Ivalid From Postal Code, please enter re-enter from postal code:";
	private final String INVALID_TO_CODE = "Ivalid To Postal Code, please enter re-enter to postal code:";
	private final String INVALID_WEIGHT = "Ivalid weight, please a number between 0g and 50g";
	private final String INVALID_LENGTH = "Ivalid length, please a number between 0cm to 200cm";
	private final String INVALID_HEIGHT = "Ivalid length, please a number between 0cm to 300cm";
	private final String INVALID_WIDTH = "Ivalid width, please a number between 0cm to 400cm";
	private final String INVALID_POSTAL_TYPE = "Ivalid postal type, please select between: Regular, Xpress, Prior";
	
	@Test
	public void ValidInputsAndRate() {
		
		
		
	}

}
