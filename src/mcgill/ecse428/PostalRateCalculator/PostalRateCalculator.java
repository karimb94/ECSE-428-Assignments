/**
 * @author Karim El-Baba
 * I.D: 260582332
 */
package mcgill.ecse428.PostalRateCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
	}

	public static ArrayList<String> parseColumn(int column) throws FileNotFoundException {
		Scanner inputStream = new Scanner(ratesFile);

		String[] temp;
		ArrayList<String> data = new ArrayList<String>();
		for (temp = (inputStream.nextLine()).split(","); temp != null;) {

			data.add(temp[column]);

			try {
				temp = (inputStream.nextLine()).split(",");
			} catch (Exception e) {
				break;

			}

		}
		return data;
	}

	public static double getRate(int in, int limitCol, int rateCol) throws FileNotFoundException {
		ArrayList<String> limits = parseColumn(limitCol);
		ArrayList<String> rates = parseColumn(rateCol);
		int i;
		for (i = 1; i < limits.size(); i++) {
			if (in <= Integer.parseInt(limits.get(i))) {
				break;
			}

		}

		if (i >= limits.size()) {
			return -1;
		}

		return Double.parseDouble(rates.get(i));
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
		double r1 = getRate(weight, 0, 1);
		double r2 = getRate(height, 2, 3);
		double r3 = getRate(length, 4, 5);
		double r4 = getRate(width, 6, 7);
		double r5 = getTypeRate(type);
		double r6 = getPostalCodeRate(to);
		double total;

		if (r1 != -1 && r2 != -1 && r3 != -1 && r4 != -1 && r5 != -1 && r6 != -1) {
			total = r1 + r2 + r3 + r4 + r5 + r6;
		} else {
			return -1;
		}

		// Add all individual rates for final rate
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
