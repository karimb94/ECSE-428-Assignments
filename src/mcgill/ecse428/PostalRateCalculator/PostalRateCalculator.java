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

	private static File ratesFile = new File("Rates.csv");

	public static void main(String[] args) throws FileNotFoundException {
	}

	/**
	 * This method is used to parse the csv file column by column.
	 * 
	 * @param column
	 *            The column desired from the csv file
	 * @return ArrayList with the column elements
	 * @throws FileNotFoundException
	 */
	public static ArrayList<String> parseColumn(int column) throws FileNotFoundException {

		Scanner inputStream = new Scanner(ratesFile);

		String[] temp;
		ArrayList<String> data = new ArrayList<String>();

		/*
		 * Parse the csv file row by row until end and add the proper cell to
		 * the return ArrayList
		 */
		while (true) {

			try {
				temp = (inputStream.nextLine()).split(",");
			} catch (Exception e) { // Break at EOF
				break;

			}
			// Add to arrayList
			data.add(temp[column]);

		}
		return data;
	}

	/**
	 * This method is used to get the rate corresponding to an input value. This
	 * is done by retrieving the limit column and the rates column desired, then
	 * finding if the desired value falls within the found limits.
	 * 
	 * @param in
	 *            input value to be compared to limits
	 * @param limitCol
	 *            The column containing the desired limits
	 * @param rateCol
	 *            The column containing the desired respective rates
	 * @return -1 if input is out of range. rate if input is within range
	 * @throws FileNotFoundException
	 */
	public static double getRate(double in, int limitCol, int rateCol) throws FileNotFoundException {
		// Parse columns in csv file to find limits and corresponding rates
		ArrayList<String> limits = parseColumn(limitCol);
		ArrayList<String> rates = parseColumn(rateCol);
		int i;
		// Check if given double is within the limits parsed form the csv file
		for (i = 1; i < limits.size(); i++) {
			if (in <= Double.parseDouble(limits.get(i))) {
				break;
			}

		}

		if (i >= limits.size()) {
			return -1;
		}

		return Double.parseDouble(rates.get(i));
	}

	/**
	 * This method is meant to find the rate associated with a parcel delivery
	 * type. This method assumes that the type has been validated to be of
	 * acceptable format.
	 * 
	 * @param type
	 *            String representing the desired type of delivery
	 * @return Parcel rate based on delivery type
	 * @throws FileNotFoundException
	 */

	public static double getTypeRate(String type) throws FileNotFoundException {
		// Parse columns in csv file to find limits and corresponding rates
		ArrayList<String> limits = parseColumn(11);
		ArrayList<String> rates = parseColumn(12);
		int i = 0;
		// Compare type to list of acceptable types to find respective rate
		for (i = 1; i < limits.size(); i++) {
			if (type.charAt(0) == limits.get(i).charAt(0)) {
				break;
			}
		}

		return Double.parseDouble(rates.get(i));

	}

	/**
	 * This method returns the rate associated with a to postal code. This
	 * method assumes that the postal code has been validated for postal code
	 * patterns.
	 * 
	 * @param to
	 *            To postal Code
	 * @return rate if within montreal, Quebec, or Canada
	 * @throws FileNotFoundException
	 */
	public static double getPostalCodeRate(String to) throws FileNotFoundException {
		// Parse columns in csv file to find limits and corresponding rates
		ArrayList<String> limits = parseColumn(9);
		ArrayList<String> rates = parseColumn(10);
		to = to.toUpperCase();
		int i = 0;

		for (i = 1; i < limits.size(); i++) { // Check if postal code is in
												// Montreal, or Quebec
			boolean inQuebec = limits.get(i).contains("|");

			if (inQuebec && (to.charAt(0) == limits.get(i).charAt(0) || to.charAt(0) == limits.get(i).charAt(2))) { // Quebec
				break;

			} else if (to.charAt(0) == limits.get(i).charAt(0)) { // Montreal
				break;
			}
		}

		if (i >= limits.size()) { // Reached last element in column
									// (representing outside of quebec)
			i--;
		}
		return Double.parseDouble(rates.get(i));

	}

	/**
	 * This method is used to find the proper postage rate of a parsel as per
	 * the weight, dimensions, and postal code of the user. The rates are
	 * calculated based on the csv file.
	 * 
	 * @param width
	 * @param height
	 * @param length
	 * @param weight
	 * @param type
	 * @param to
	 * @return
	 * @throws FileNotFoundException
	 */
	public double getFullRate(double width, double height, double length, double weight, String type, String to)
			throws FileNotFoundException {
		// Calculate the individual rates
		double r1 = getRate(weight, 0, 1);
		double r2 = getRate(height, 2, 3);
		double r3 = getRate(length, 4, 5);
		double r4 = getRate(width, 6, 7);
		double r5 = getTypeRate(type);
		double r6 = getPostalCodeRate(to);
		double total;

		// If all rates are good, return sum. Else return -1
		if (r1 != -1 && r2 != -1 && r3 != -1 && r4 != -1 && r5 != -1 && r6 != -1) {
			total = r1 + r2 + r3 + r4 + r5 + r6;
			return total;
		} else {
			return -1;
		}

	}

	/**
	 * This method is used to validate the input postal codes entered by the
	 * user.
	 * 
	 * @param from
	 *            The desired from postal code (must be within montreal,
	 *            starting with an H, and matching postal code pattern)
	 * @param to
	 *            The desired destination postal code (must match postal code
	 *            pattern)
	 * @return false for incorrect postal codes, true if postal codes are good
	 */
	public static boolean validatePostalCode(String from, String to) {
		// Regular expression used to validate A1A 1A1 patter for postal code
		// From postal code must start with H
		// To postal code must only match top pattern
		String fromPostalCodeRules = "^[hH][0-9][a-zA-Z] ?[0-9][a-zA-Z][0-9]$";
		String toPostalCodeRules = "^[a-zA-Z][0-9][a-zA-Z] ?[0-9][a-zA-Z][0-9]$";

		Pattern toPostalCode = Pattern.compile(fromPostalCodeRules);
		Pattern fromPostalCode = Pattern.compile(toPostalCodeRules);

		// Validate syntax for postal codes
		Matcher matcher = fromPostalCode.matcher(from);
		Matcher matcher2 = toPostalCode.matcher(to);

		// Check for matches with REGEX patterns
		if (!matcher.matches()) {
			System.out.println("Ivalid From Postal Code, please enter re-enter from postal code");
			return false;
		} else if (!matcher2.matches()) {
			System.out.print("Ivalid To Postal Code, please enter re-enter to postal code");
			return false;
		}

		return true;
	}

	/**
	 * This method is used to ensure that the user selects the appropriate type
	 * of postage. The validation is done using a regular expression
	 * 
	 * @param type
	 *            The type of postage desired by the user
	 * @return Returns true if one of the three postage types is entered. False
	 *         otherwise
	 */
	public static boolean validatePostalType(String type) {
		type = type.toUpperCase();
		// Regex used to check each of the three types desired
		if (type.matches("REGULAR|XPRESS|PRIORITY")) {
			System.out.println("Ivalid To Postal type!");
			return true;
		}

		return false;

	}

}
