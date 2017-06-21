package hackerrank.datastructures.arrays._0022darray;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 21..
 */
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[6][6];
		for(int arr_i=0; arr_i < 6; arr_i++){
			for(int arr_j=0; arr_j < 6; arr_j++){
				arr[arr_i][arr_j] = in.nextInt();
			}
		}

		int maxSum = -9*7;
		for(int arr_i = 0 ; arr_i < 4 ; arr_i++ ){
			for( int arr_j = 0 ; arr_j < 4 ; arr_j++ ){
				int sum = arr[arr_i][arr_j] + arr[arr_i][arr_j+1] + arr[arr_i][arr_j+2];
				sum += arr[arr_i+1][arr_j+1];
				sum += arr[arr_i+2][arr_j] + arr[arr_i+2][arr_j+1] + arr[arr_i+2][arr_j+2];
				if( sum > maxSum ) maxSum = sum;
			}
		}

		System.out.println(maxSum);
	}

}
