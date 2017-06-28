package hackerrank.tutorials.crackingthecodinginterview._009_bubblesort;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 28..
 */
public class Solution {

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);

		int[] array = new int[scanner.nextInt()];
		for( int inx = 0 ; inx < array.length ; inx++ ){
			array[inx] = scanner.nextInt();
		}

		int totalSwaps = 0;
		for (int i = 0; i < array.length; i++) {
			// Track number of elements swapped during a single array traversal
			int numberOfSwaps = 0;

			for (int j = 0; j < array.length - 1; j++) {
				// Swap adjacent elements if they are in decreasing order
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					numberOfSwaps++;
				}
			}

			totalSwaps += numberOfSwaps;
			// If no elements were swapped during a traversal, array is sorted
			if (numberOfSwaps == 0) {
				break;
			}
		}

		System.out.println("Array is sorted in " + totalSwaps + " swaps.");
		System.out.println("First Element: " + array[0]);
		System.out.println("Last Element: " + array[array.length-1]);


	}
}
