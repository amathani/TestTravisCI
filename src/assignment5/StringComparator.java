/**
 * 
 */
package assignment5;

import java.util.Comparator;

/**
 * Comparator for String array
 * @author Amit Athani and Natalie Cottrill-Yavornitzky
 *
 */
public class StringComparator<T> implements Comparator<String> {

	@Override
	/**
	 * Comparator for Integer array
	 */
	public int compare(String string1, String string2) {
		return string1.compareToIgnoreCase(string2);
	
	}
}
