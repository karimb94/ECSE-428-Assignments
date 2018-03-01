/**
 * @author Karim El-Baba
 * I.D: 260582332
 */
package mcgill.ecse428.PostalRateCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PostalRateCalculator {

	private final String fileName = "Rates.csv";
	private File ratesFile = new File(fileName);

	public static void main(String[] args) {
	}

	public double getValidRate() throws FileNotFoundException {
		String rate = null;
		String test;
		int lineCount = 0;
		Scanner inputStream = new Scanner(ratesFile);
		
		while(inputStream.hasNext()){
			//Find Rate from csv File
			if(lineCount == 1){
				rate = inputStream.nextLine();
				String [] rate2 = rate.split(",");
				rate = rate2[rate2.length-1];
				break;
			}
			inputStream.nextLine();
			lineCount++;
		}
		return Double.parseDouble(rate);
	}

}
