package assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class SortMain {

	public static void main(String[] args) {

		int size = 0;
		int repetitions = 10000;

//		size = 0;
//		for (int x = 1; x < 11; x++) {
//			size = size+10000;
//			timeMergeSortBest(repetitions, size);
//		}
//		size = 0;
//		for (int x = 1; x < 11; x++) {
//			size = size+10000;
//			timeMergeSortRandom(repetitions, size);
//		}
//		size = 0;
//		for (int x = 1; x < 11; x++) {
//			size = size+10000;
//			timeMergeSortWorst(repetitions, size);
//		}
//		size = 0;
//		for (int x = 1; x < 11; x++) {
//			size = size+1000;
//			timeQuickSortBest(repetitions, size);
//		}
		size = 0;
		for (int x = 1; x < 11; x++) {
			size = size+10000;
			timeQuickSortRandom(repetitions, size);
		}
//		size = 0;
//		for (int x = 1; x < 11; x++) {
//			size = size+10000;
//			timeQuickSortWorst(repetitions, size);
//		}
	}

	private static void timeQuickSortRandom(int repetitions, int size) {
		long avgTimeQuickRandom = 0;
		long startTime = 0;
		long endTime = 0;
		ArrayList<Integer> randomArray = generateAverageCase(size);
		ArrayList<Integer> randomArray1 = new ArrayList<Integer>(size);
		for (int m = 0; m < size; m++)
			randomArray1.add(null);
		Comparator cmp = new IntegerComparator<Integer>();
		
		for (int i = 0; i < repetitions; i++) {
			for (int z = 0; z < randomArray.size(); z++) {
				randomArray1.set(z, randomArray.get(z));
			}
			startTime = System.nanoTime();
			SortUtil.quicksort(randomArray1, cmp);
			endTime = System.nanoTime();
			avgTimeQuickRandom += (endTime - startTime);
		}

		System.out.println("Quicksort of " + size + " of random case "
				+ (avgTimeQuickRandom = avgTimeQuickRandom / repetitions));
	}
	
	private static void timeQuickSortWorst(int repetitions, int size) {
		long avgTimeQuickWorst = 0;
		long startTime = 0;
		long endTime = 0;
		ArrayList<Integer> randomArray = generateWorstCase(size);
		ArrayList<Integer> randomArray1 = new ArrayList<Integer>(size);
		for (int m = 0; m < size; m++)
			randomArray1.add(null);
		Comparator cmp = new IntegerComparator<Integer>();
		
		for (int i = 0; i < repetitions; i++) {
			for (int z = 0; z < randomArray.size(); z++) {
				randomArray1.set(z, randomArray.get(z));
			}
			startTime = System.nanoTime();
			SortUtil.quicksort(randomArray1, cmp);
			endTime = System.nanoTime();
			avgTimeQuickWorst += (endTime - startTime);
		}

		System.out.println("Quicksort of " + size + " of worst case "
				+ (avgTimeQuickWorst = avgTimeQuickWorst / repetitions));
	}
	
	private static void timeQuickSortBest(int repetitions, int size) {
		long avgTimeQuickBest = 0;
		long startTime = 0;
		long endTime = 0;
		ArrayList<Integer> bestArray = generateBestCase(size);
		ArrayList<Integer> bestArray1 = new ArrayList<Integer>(size);
		for (int m = 0; m < size; m++)
			bestArray1.add(null);
		Comparator cmp = new IntegerComparator<Integer>();
		
		for (int i = 0; i < repetitions; i++) {
			for (int z = 0; z < bestArray.size(); z++) {
				bestArray1.set(z, bestArray.get(z));
			}
			startTime = System.nanoTime();
			SortUtil.quicksort(bestArray1, cmp);
			endTime = System.nanoTime();
			avgTimeQuickBest += (endTime - startTime);
		}

		System.out.println("Quicksort of " + size + " of best case "
				+ (avgTimeQuickBest = avgTimeQuickBest / repetitions));
	}

	public static ArrayList<Integer> generateBestCase(int size) {
		ArrayList<Integer> arrayBest = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			arrayBest.add(i);
		}
		return arrayBest;
	}

	public static ArrayList<Integer> generateAverageCase(int size) {
		ArrayList<Integer> arrayAvg = new ArrayList<Integer>();
		Random rand = new Random();
		rand.setSeed(104729);
		for (int i = 0; i < size; i++) {
			arrayAvg.add(rand.nextInt(size + 1));
		}
		return arrayAvg;
	}

	public static ArrayList<Integer> generateWorstCase(int size) {
		ArrayList<Integer> arrayWorst = new ArrayList<Integer>();
		for (int i = size - 1; i > -1; i--) {
			arrayWorst.add(i);
		}
		return arrayWorst;
	}

	public static void timeMergeSortRandom(int repetitions, int size) {
		long avgTimeMerge = 0;
		long startTime = 0;
		long endTime = 0;
		ArrayList<Integer> randomArray = generateAverageCase(size);
		ArrayList<Integer> randomArray1 = new ArrayList<Integer>(size);
		for (int m = 0; m < size; m++)
			randomArray1.add(null);
		Comparator cmp = new IntegerComparator<Integer>();

		for (int i = 0; i < repetitions; i++) {
			for (int z = 0; z < randomArray.size(); z++) {
				randomArray1.set(z, randomArray.get(z));
			}
			startTime = System.nanoTime();
			SortUtil.mergesort(randomArray1, cmp);
			endTime = System.nanoTime();
			avgTimeMerge += (endTime - startTime);
		}

		System.out.println("Mergesort of " + size + " of random case "
				+ (avgTimeMerge = avgTimeMerge / repetitions));
	}

	public static void timeMergeSortBest(int repetitions, int size) {
		long avgTimeMergeBest = 0;
		long startTime = 0;
		long endTime = 0;
		ArrayList<Integer> bestArray = generateBestCase(size);
		ArrayList<Integer> bestArray1 = new ArrayList<Integer>(size);
		for (int m = 0; m < size; m++)
			bestArray1.add(null);
		Comparator cmp = new IntegerComparator<Integer>();

		for (int i = 0; i < repetitions; i++) {
			for (int z = 0; z < bestArray.size(); z++) {
				bestArray1.set(z, bestArray.get(z));
			}
			startTime = System.nanoTime();
			SortUtil.mergesort(bestArray1, cmp);
			endTime = System.nanoTime();
			avgTimeMergeBest += (endTime - startTime);
		}
		System.out.println("Mergesort of " + size + " of best case "
				+ (avgTimeMergeBest = avgTimeMergeBest / repetitions));
	}
	
	public static void timeMergeSortWorst(int repetitions, int size) {
		long avgTimeMergeWorst = 0;
		long startTime = 0;
		long endTime = 0;
		ArrayList<Integer> randomArray = generateWorstCase(size);
		ArrayList<Integer> randomArray1 = new ArrayList<Integer>(size);
		for (int m = 0; m < size; m++)
			randomArray1.add(null);
		Comparator cmp = new IntegerComparator<Integer>();

		for (int i = 0; i < repetitions; i++) {
			for (int z = 0; z < randomArray.size(); z++) {
				randomArray1.set(z, randomArray.get(z));
			}
			startTime = System.nanoTime();
			SortUtil.mergesort(randomArray1, cmp);
			endTime = System.nanoTime();
			avgTimeMergeWorst += (endTime - startTime);
		}

		System.out.println("Mergesort of " + size + " of worst case "
				+ (avgTimeMergeWorst = avgTimeMergeWorst / repetitions));
	}
}
