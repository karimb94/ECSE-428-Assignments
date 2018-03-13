/**
 * @author Karim El-Baba
 * I.D: 260582332
 */
package mcgill.ecse428.PostalRateCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PostalRateCalculator {

	private static File ratesFile = new File("Rates.csv");

	public static void main(String[] args) throws FileNotFoundException {

	}

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

	public static double getRate(double in, int limitCol, int rateCol) throws FileNotFoundException {
		// Parse columns in csv file to find limits and corresponding rates
		ArrayList<String> limits = parseColumn(limitCol);
		ArrayList<String> rates = parseColumn(rateCol);
		int i;

		// Check if given double is within the limits parsed form the csv
		// file
		for (i = 1; i < limits.size(); i++) {
			if (in <= Double.parseDouble(limits.get(i))) {
				break;
			}

		}
		return Double.parseDouble(rates.get(i));
	}

	public static double getTypeRate(String type) throws FileNotFoundException {
		// Parse columns in csv file to find limits and corresponding rates
		ArrayList<String> limits = parseColumn(11);
		ArrayList<String> rates = parseColumn(12);

		type = type.toUpperCase();
		int i = 1;
		// Compare type to list of acceptable types to find respective rate
		for (i = 1; i < limits.size(); i++) {
			System.out.println(limits.get(i).charAt(0));
			if (type.charAt(0) == limits.get(i).charAt(0)) {
				break;
			}
		}

		return Double.parseDouble(rates.get(i));
	}

}
