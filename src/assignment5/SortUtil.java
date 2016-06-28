/**
 * 
 */
package assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author Amit Athani and Natalie Cottrill-Yavornitzky *
 */
public class SortUtil {

	private static final int threshold = 25;

	/**
	 * Driver method. Sets up recursive sort for mergesort.
	 * 
	 * @param list
	 * @param cmp
	 */
	public static <T> void mergesort(ArrayList<T> list,
			Comparator<? super T> cmp) {
		if (list == null || list.size() == 0)
			return;
		ArrayList<T> temp = new ArrayList<T>(list.size());
		for (int i = 0; i < list.size(); i++) {
			temp.add(null);
		}
		recursiveMergesort(list, cmp, 0, list.size() - 1, temp);
	}

	/**
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 * 
	 * @param arr
	 * @param cmp
	 */
	public static <T> void insertionsort(ArrayList<T> list,
			Comparator<? super T> cmp, int low, int high) {
		for (int i = low + 1; i <= high; i++) {
			T temp = list.get(i);

			// j = the number of items sorted so far
			int j;
			for (j = i - 1; j >= low && cmp.compare(temp, list.get(j)) < 0; j--) {
				list.set(j + 1, list.get(j));
			}
			// insert the char in the sorted part of array
			list.set(j + 1, temp);
		}
	}

	private static <T> void insertionsort(T[] arr, Comparator<? super T> cmp,
			int low, int high) {
		int j;
		for (int i = low + 1; i < arr.length; i++) {
			T temp = arr[i];

			// j = the number of items sorted so far
			for (j = i - 1; j >= 0 && cmp.compare(temp, arr[j]) < 0; j--) {
				arr[j + 1] = arr[j];
			}
			// insert the char in the sorted part of array
			arr[j + 1] = temp;
		}
	}

	/**
	 * The recursive method which implements mergesort algorithm
	 * 
	 * @param list
	 * @param cmp
	 * @param low
	 * @param high
	 * @param temp
	 */
	private static <T> void recursiveMergesort(ArrayList<T> list,
			Comparator cmp, int low, int high, ArrayList<T> temp) {
		int mid = 0;
		// Only enter loop if low is < high
		if (low < high) {
			if ((high - low) <= threshold) // Perform insertion sort if the size
											// of the sub-array to be sorted is
											// less than threshold i.e less than
											// 25
				insertionsort(list, cmp, low, high);
			else {
				mid = (high + low) / 2;
				recursiveMergesort(list, cmp, low, mid, temp);
				recursiveMergesort(list, cmp, mid + 1, high, temp);
				merge(list, cmp, low, high, temp);
			}
		}
	}

	/**
	 * Merge two sorted arrays.
	 * 
	 * @param left
	 *            smaller values array
	 * @param right
	 *            larger values array
	 * @param dest
	 *            destination array
	 * @param cmp
	 *            comparator
	 */
	private static <T> void merge(ArrayList<T> list, Comparator cmp, int low,
			int high, ArrayList<T> temp) {
		int left, mid, tempIndex, right;
		left = low;
		mid = (high + low) / 2;
		right = mid + 1;
		tempIndex = low;
		// To insert into the auxiliary array when there are elements present in
		// both the sub-arrays
		while (left <= mid && right <= high) {
			if (cmp.compare(list.get(left), list.get(right)) < 0) {
				temp.set(tempIndex, list.get(left));
				left++;
				tempIndex++;
			} else {
				temp.set(tempIndex, list.get(right));
				right++;
				tempIndex++;
			}
		}
		// To insert the remaining parts of the left sub-array
		while (left <= mid) {
			temp.set(tempIndex, list.get(left));
			tempIndex++;
			left++;
		}
		// To insert the remaining parts of the right sub-array
		while (right <= high) {
			temp.set(tempIndex, list.get(right));
			tempIndex++;
			right++;
		}
		left = low;
		// Adding the elements from the temp array list to the main list
		for (int i = 0; i <= (high - low); i++) {
			list.set(left, temp.get(left));
			left++;
		}

	}

	/**
	 * Quicksort driver method
	 * 
	 * @param arr
	 * @param StringArrayComparator
	 */
	public static <T> void quicksort(ArrayList<T> list,
			Comparator<? super T> cmp) {

		if (list == null || list.size() == 0)
			return;
		T[] arr = (T[]) new Object[list.size()]; // create generic array and
		list.subList(0, (list.size())).toArray(arr); // copy contents from input
														// ArrayList

		// Switch different pivots (1st element, middle element, or random
		// element)
		recursiveQuicksort(arr, 0, arr.length - 1, cmp);

		for (int i = 0; i < arr.length; i++) {
			list.set(i, arr[i]);
		}
	}

	/**
	 * Finds the pivot by finding the median elements from the list passed.
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param cmp
	 * @return
	 */
	private static <T> int findPivot(T[] arr, int low, int high, Comparator cmp) {
		if (low < high) {
			Random rand = new Random();
			// Indices between low and high
			int index1 = low;
			int index2 = (high + low) / 2;
			int index3 = high;
			// Adding these elements to a temp array
			T[] temp = (T[]) new Object[] { arr[index1], arr[index2],
					arr[index3] };
			// Performing insertion sort on the temp array
			insertionsort(temp, cmp, low, high);

			// Comparing the middle element of the sorted sub array with indices
			if (cmp.compare(temp[1], arr[index1]) == 0)
				return index1;
			else if (cmp.compare(temp[1], arr[index2]) == 0)
				return index2;
			else if (cmp.compare(temp[1], arr[index3]) == 0)
				return index3;
		}
		return low;
	}

	/**
	 * Generate a random pivot
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param cmp
	 * @return
	 */
	public static <T> int randomPivot(T[] arr, int low, int high, Comparator cmp) {
		Random rand = new Random();
		int randomIndex = rand.nextInt((high - low) + 1) + low;
		return randomIndex;

	}

	/**
	 * The recursive method to perform quicksort
	 * 
	 * @param arr
	 *            Generic array T[]
	 * @param low
	 *            lowest index
	 * @param high
	 *            highest index
	 * @param cmp
	 *            Comparator
	 */
	private static <T> void recursiveQuicksort(T[] arr, int low, int high,
			Comparator<T> cmp) {
		// Step 1. pick value of middle index as pivot
		T pivot = arr[(low + high) / 2];
		// T pivot = arr[findPivot(arr, low, high, cmp)];
		// T pivot = arr[low];
		int indexL = low;
		int indexR = high;
		if (indexL > indexR)
			return;

		// Step 2. divide array into two sets on either side of pivot
		while (indexL <= indexR) {
			// look for value in lhs that is bigger than pivot
			while (cmp.compare(arr[indexL], pivot) < 0) {
				indexL++;
			}
			// look for value in rhs that is smaller than pivot
			while (cmp.compare(arr[indexR], pivot) > 0) {
				indexR--;
			}
			// if index of lhs <= index rhs, swap values
			if (indexL <= indexR) {
				T tempSaved = arr[indexL];
				arr[indexL] = arr[indexR];
				arr[indexR] = tempSaved;
				// move index to the next position on both sides
				indexL++;
				indexR--;
			}
		}
		// call quickSort method recursively, splitting & sorting array
		if (low < indexR)
			recursiveQuicksort(arr, low, indexR, cmp);
		if (indexL < high)
			recursiveQuicksort(arr, indexL, high, cmp);
	}
}
