/**
 * 
 */
package assignment5;

import java.util.Comparator;

/**
 * Comparator for Integer array
 * @author Amit Athani and Natalie Cottrill-Yavornitzky
 *
 */
public class IntegerComparator<T> implements Comparator<Integer> {

	@Override
	/**
	 * Comparator for Integer array
	 */
	public int compare(Integer int1, Integer int2) {
		return int1.compareTo(int2);
	
	}
}
