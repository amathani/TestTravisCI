package assignment5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author Natalie D. Cottrill-Yavornitzky and Amit Athani
 *
 */
public class TestGenerator {
	
	private static Random rand;

	// Create a random string [a-z] of specified length
	public static String randomString (int length) {
		
		// Set up the random number generator for the randomString function
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		
		String retval = "";
		for (int i = 0; i < length; i++) {
			// ASCII values a-z,A-Z are contiguous (52 characters)
			retval += (char) ('a' + (rand.nextInt(26)));
		}
		return retval;
	}

	// Reads words from a file (assumed to contain one word per line)
	// Returns the words as an array of strings.
	public static String[] readFile(String filename) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));
			while (input.ready()) {
				results.add(input.readLine());
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] retval = new String[1];
		return results.toArray(retval);
	}	
}
