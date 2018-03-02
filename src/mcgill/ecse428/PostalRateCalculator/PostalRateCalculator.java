/**
 * @author Karim El-Baba
 * I.D: 260582332
 */
package mcgill.ecse428.PostalRateCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostalRateCalculator {

	private final String fileName = "Rates.csv";
	private File ratesFile = new File(fileName);

	private String postalCodeRules = "^[a-zA-Z][0-9][a-zA-Z] ?[0-9][a-zA-Z][0-9]$";
	private Pattern postalCode = Pattern.compile(postalCodeRules);
	
	public static void main(String[] args) {
	}

	public double getValidRate() throws FileNotFoundException {
		String rate = null;
		String test;
		int lineCount = 0;
		Scanner inputStream = new Scanner(ratesFile);

		while (inputStream.hasNext()) {
			// Find Rate from csv File
			if (lineCount == 1) {
				rate = inputStream.nextLine();
				String[] rate2 = rate.split(",");
				rate = rate2[rate2.length - 1];
				break;
			}
			inputStream.nextLine();
			lineCount++;
		}
		return Double.parseDouble(rate);
	}

	public boolean validatePostalCode(boolean type, String postal) {
		// for type = true, input is FROM Postal code
		// for type = false, input is
		Matcher matcher = postalCode.matcher(postal);
		
		if(!matcher.matches()){
			System.out.print("Ivalid From Postal Code, please enter re-enter from postal code");
			return false;
		}

		return true;

	}

}
