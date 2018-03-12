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

	private final int WEIGHT_LIMIT_1 = 200;
	private final int WEIGHT_LIMIT_2 = 300;
	private final int WEIGHT_LIMIT_3 = 400;

	private final int DIMENSION_LIMIT_1 = 50;
	private final int DIMENSION_LIMIT_2 = 100;
	private final int DIMENSION_LIMIT_3 = 150;

	private static File ratesFile = new File("Rates.csv");

	private String fromPostalCodeRules = "^[hH][0-9][a-zA-Z] ?[0-9][a-zA-Z][0-9]$";
	private String toPostalCodeRules = "^[a-zA-Z][0-9][a-zA-Z] ?[0-9][a-zA-Z][0-9]$";

	private Pattern toPostalCode = Pattern.compile(fromPostalCodeRules);
	private Pattern fromPostalCode = Pattern.compile(toPostalCodeRules);

	public static void main(String[] args) throws FileNotFoundException {
		getWeightRate(5);
	}

	public static double getWeightRate(int weight) throws FileNotFoundException {
		String[] limits;
		Scanner inputStream = new Scanner(ratesFile);

		limits = inputStream.nextLine().split(",");

		System.out.println(limits[2]);
		return weight;

	}

	public double getHeightRate(int height) {
		return 0;
	}

	public double getLengthRate(int length) {
		return 0;

	}

	public double getWidthRate(int width) {
		return 0;

	}

	public double getTypeRate(String type) {
		return 0;

	}

	public double getPostalCodeRate(String to) {
		return 0;

	}

	public double getFullRate(int width, int height, int length, int weight, String type, String to)
			throws FileNotFoundException {
		// Calculate the individual rates
		double r1 = getWeightRate(weight);
		double r2 = getHeightRate(height);
		double r3 = getLengthRate(length);
		double r4 = getWidthRate(width);
		double r5 = getTypeRate(type);
		double r6 = getPostalCodeRate(to);

		// Add all individual rates for final rate
		double total = r1 + r2 + r3 + r4 + r5 + r6;

		return total;
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
