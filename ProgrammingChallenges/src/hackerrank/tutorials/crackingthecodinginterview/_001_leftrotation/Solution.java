package hackerrank.tutorials.crackingthecodinginterview._001_leftrotation;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 26..
 */
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}

		for(int inx = k ; inx < n ; inx++ ){
			System.out.print(a[inx] + " ");
		}

		for(int inx = 0 ; inx < k ; inx++){
			System.out.print(a[inx] + " ");
		}
	}

}
