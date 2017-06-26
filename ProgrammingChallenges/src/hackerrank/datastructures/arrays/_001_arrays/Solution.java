package hackerrank.datastructures.arrays._001_arrays;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int arr_i=n-1; arr_i > -1; arr_i--){
			arr[arr_i] = in.nextInt();
		}

		StringBuffer result = new StringBuffer();
		for( int number : arr){
			result.append(number).append(" ");
		}
		System.out.println(result.toString().trim());

	}
}

