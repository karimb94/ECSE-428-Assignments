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
	double errorMargin = 0.000001;

	/**
	 * This test is to ensure the ability to obtain a rate from the weight
	 * column
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void wieghtRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.3;
		double weight = 0.1;
		double found_Rate = PostalRateCalculator.getRate(weight, 0, 1);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	/**
	 * This test is to ensure the ability to obtain a rate from the height
	 * column
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void heightRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.4;
		double height = 49;
		double found_Rate = PostalRateCalculator.getRate(height, 2, 3);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	/**
	 * This test is to ensure the ability to obtain a rate from the length
	 * column
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void lengthRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.7;
		double length = 99;
		double found_Rate = PostalRateCalculator.getRate(length, 4, 5);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	/**
	 * This test is to ensure the ability to obtain a rate from the width column
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void widthRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.9;
		double width = 101;
		double found_Rate = PostalRateCalculator.getRate(width, 6, 7);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

	/**
	 * This test is to ensure the ability to obtain a rate from the type of
	 * postage column
	 * 
	 * @throws FileNotFoundException
	 */
	@Test
	public void typeRate() throws FileNotFoundException {
		double EXPECTED_RATE = 0.5;
		String type = "Xpress";
		double found_Rate = PostalRateCalculator.getTypeRate(type);
		assertEquals(EXPECTED_RATE, found_Rate, errorMargin);
	}

}
