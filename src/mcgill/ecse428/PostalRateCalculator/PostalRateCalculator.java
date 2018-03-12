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

	private String fromPostalCodeRules = "^[hH][0-9][a-zA-Z] ?[0-9][a-zA-Z][0-9]$";
	private String toPostalCodeRules = "^[a-zA-Z][0-9][a-zA-Z] ?[0-9][a-zA-Z][0-9]$";

	private Pattern toPostalCode = Pattern.compile(fromPostalCodeRules);
	private Pattern fromPostalCode = Pattern.compile(toPostalCodeRules);

	public static void main(String[] args) {
	}

	public double getWeightRate() {
		return 0;

	}

	public double getHeightRate() {
		return 0;
	}

	public double getLengthRate() {
		return 0;

	}

	public double getWidthRate() {
		return 0;

	}

	public double getTypeRate() {
		return 0;

	}

	public double getPostalCodeRate() {
		return 0;

	}

	public double getFullRate() {
		return 0;
	}

	public boolean validRange() {
		return false;
	}

	public boolean validType() {
		return false;

	}

	public boolean validatePostalCode(String from, String to) {

		// Validate syntax for postal codes
		Matcher matcher = fromPostalCode.matcher(from);
		Matcher matcher2 = toPostalCode.matcher(to);

		if (!matcher.matches()) {
			System.out.print("Ivalid From Postal Code, please enter re-enter from postal code");
			return false;
		} else if (!matcher2.matches()) {
			System.out.print("Ivalid To Postal Code, please enter re-enter to postal code");
			return false;
		}

		return true;
	}

	public double getValidRateWeight() throws FileNotFoundException {
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

}
