package searching;

import java.util.ArrayList;

public class Sorting {

	private String[] array;
	private ArrayList<String> sort;

	// Creating the Sorting object:
	public Sorting() {
		this.sort = new ArrayList<>();
		this.array = new String[sort.size()];

	}

	// Passing the ArrayList to be sorted:
	public void sort(ArrayList<String> list) {
		this.sort = list;
		this.array = new String[sort.size()];
		getArray(); // Copying the ArrayList into an array;
		mergeSort(array); // Sorting the array;
		printArray(array); // Returning the array sorted;

	}

	// Copying the ArrayList passed into an array:
	public String[] getArray() {
		for (int i = 0; i < sort.size(); i++) {
			array[i] = sort.get(i);
		}

		return array;
	}

	// Method to sort the array:
	public void mergeSort(String[] array) {

		if (array.length > 1) {

			int firstHalfSize = array.length / 2; // Getting half of the size of the array to be sorted;
			String[] firstHalf = new String[firstHalfSize]; // Creating a new array;
			System.arraycopy(array, 0, firstHalf, 0, firstHalfSize); // Copying half of the array to be sorted into the
																		// new array;

			int secondHalfSize = array.length - firstHalfSize; // Getting the remaining of the size of the array to be
																// sorted;
			String[] secondHalf = new String[secondHalfSize]; // Creating a new array;
			System.arraycopy(array, firstHalfSize, secondHalf, 0, secondHalfSize); // Copying the remaining of the array
																					// to be sorted into the new array;

			// Looping the functions until they can be divided and merged:
			mergeSort(firstHalf);
			mergeSort(secondHalf);

			merge(firstHalf, secondHalf, array); // Calling the merging function;
		}
	}

	// Merging the two sorted arrays into a single array;
	private void merge(String[] a, String[] b, String[] c) {

		int countA = 0; // Elements in array a;
		int countB = 0; // Elements in array b;
		int countC = 0; // Elements in array c;

		// Looping while arrays 'a' and 'b' have elements to be merged:
		while (a.length > countA && b.length > countB) {
			// Comparing the Strings:
			if ((a[countA].compareTo(b[countB])) < 0) { // If element of array 'a' comes before the element of array 'b'
				c[countC] = a[countA]; // Array 'c' receiving element of array 'a';
				countA++; // Increasing index of the array 'a';

			} else { // If element of array 'b' comes before the element of array 'a'
				c[countC] = b[countB]; // Array 'c' receiving element of array 'b';
				countB++; // Increasing index of the array 'b';
			}
			countC++; // Increasing index of the array 'c';
		}

		// Looping while array 'a' still has elements to be merged:
		while (a.length > countA) {
			c[countC] = a[countA]; // Array 'c' receiving element of array 'a';
			countC++; // Increasing index of the array 'c';
			countA++; // Increasing index of the array 'a';
		}

		// Looping while array 'b' still has elements to be merged:
		while (b.length > countB) {
			c[countC] = b[countB]; // Array 'c' receiving element of array 'b';
			countC++; // Increasing index of the array 'c';
			countB++; // Increasing index of the array 'b';
		}
	}

	// Printing the new sorted array:
	public void printArray(String[] array) {

		String toPrint = "List: \n";
		for (int i = 0; i < array.length; i++) {
			toPrint += array[i] + "";

		}

		System.out.println(toPrint);

	}
}
