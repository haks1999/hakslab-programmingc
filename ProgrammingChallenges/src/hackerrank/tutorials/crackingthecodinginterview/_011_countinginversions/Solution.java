package hackerrank.tutorials.crackingthecodinginterview._011_countinginversions;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 29..
 */
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){
			int n = in.nextInt();
			int arr[] = new int[n];
			for(int arr_i=0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
			}
			System.out.println(countInversions(arr));
		}
	}

	static int countInversions(int[] arr){
		int totalSwaps = 0;
			for( int inx = 0 ; inx < arr.length - 1 ; inx++ ){
				if( arr[inx] <= arr[inx+1] ) continue;
				for( int jnx = inx+1; jnx > 0 ; jnx-- ){
					if( arr[jnx] < arr[jnx-1]){
						int temp = arr[jnx];
						arr[jnx] = arr[jnx-1];
						arr[jnx-1] = temp;
						totalSwaps++;
					}else{
						break;
					}
				}
			}

		return totalSwaps;
	}

}
