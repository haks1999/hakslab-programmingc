package hackerrank.datastructures.arrays._004_leftrotation;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 21..
 */
public class Solution {

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);

		int size = in.nextInt();
		int rotate = in.nextInt();

		int[] array = new int[size];
		for( int inx = 0 ; inx < size ; inx++ ){
			array[inx] = in.nextInt();
		}

		for( int inx = rotate ; inx < size ; inx++ ){
			System.out.print(array[inx] + " ");
		}
		for( int inx = 0 ; inx < rotate ; inx++ ){
			System.out.print(array[inx] + " ");
		}

	}
}
