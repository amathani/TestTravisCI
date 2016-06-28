package assignment5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Natalie D. Cottrill-Yavornitzky and Amit Athani
 *
 */
public class SortUtilTest {
	private String[] letterArray;
	private Character[] charArray;
	private Integer[] integerArrayBestCase;
	private Integer[] integerArrayAvgCase;
	private Integer[] integerArrayWorstCase;

	long avgTime = 0;
	long endTime = 0;
	long startTime = 0;

	@Before
	public void setUp() throws Exception {
		letterArray = new String[] { "e", "x", "g", "k", "u", "m", "b", "z",
				"j", "w" };

	}

	@Test
	public void testMergesort() {

		ArrayList<String> answer = new ArrayList<String>(Arrays.asList("b",
				"e", "g", "j", "k", "m", "u", "w", "x", "z"));
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("e", "x",
				"g", "k", "u", "m", "b", "z", "j", "w"));
		SortUtil.mergesort(list, new StringComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.print(" printed Mergesort \n");
		assertEquals(answer, list);
	}

	@Test
	public void testMergesort2() {
		ArrayList<Integer> answer = new ArrayList<Integer>(Arrays.asList(1, 2,
				3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(13, 9,
				3, 16, 2, 5, 10, 8, 11, 12, 14, 15, 1, 4, 7, 6));
		SortUtil.mergesort(list, new IntegerComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.print(" printed Mergesort \n");
		assertEquals(answer, list);
	}

	@Test
	public void testinsertionsort() {
		ArrayList<String> answer = new ArrayList<String>(Arrays.asList("b",
				"e", "g", "j", "k", "m", "u", "w", "x", "z"));
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("e", "x",
				"g", "k", "u", "m", "b", "z", "j", "w"));
		SortUtil.insertionsort(list, new StringComparator(), 0, list.size() - 1);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.print(" printed Insertionsort \n");
		assertEquals(answer, list);
	}

	@Test
	public void testQuicksort() {
		ArrayList<String> answer = new ArrayList<String>(Arrays.asList("b",
				"e", "g", "j", "k", "m", "u", "w", "x", "z"));
		ArrayList<String> list = new ArrayList<String>(Arrays.asList("e", "x",
				"g", "k", "u", "m", "b", "z", "j", "w", "y"));
		SortUtil.quicksort(list, new StringComparator());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
		System.out.print(" printed Quicksort \n");
		assertEquals(answer, list);
		ArrayList<Character> answer1 = new ArrayList<Character>(Arrays.asList(
				'a', 'b', 'c', 'c', 'd', 'e', 'e', 'f'));
		ArrayList<Character> list1 = new ArrayList<Character>(Arrays.asList(
				'b', 'a', 'c', 'e', 'c', 'd', 'e', 'f'));

		SortUtil.quicksort(list1, new CharacterComparator());
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i));
		}
		System.out.print(" printed Quicksort \n");
		assertEquals(answer1, list1);

	}

	@Test
	public <T> void testFindPivot() {
		Object[] list = new Object[] { 100, 121, 2, 45, 11, 1, 14, 16, 98, 140,
				3 };
		System.out.println("length of list " + list.length);
		// int pivot = SortUtil.findPivot(list, 0, list.length - 1,
		// new IntegerComparator());
		// System.out.print(list[pivot] + " printed Pivot \n");

	}
}
