package hackerrank.tutorials.crackingthecodinginterview._016_primality;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 29..
 */
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		for(int a0 = 0; a0 < p; a0++){
			int n = in.nextInt();

			checkPrime(n);
		}
	}

	static void checkPrime(int n){

		if( n == 1){
			System.out.println("Not prime");
			return;
		}


		if( n < 4){
			System.out.println("Prime");
			return;
		}

		if( n % 2 < 1){
			System.out.println("Not prime");
			return;
		}

		for ( int inx = 3 ; inx < Math.ceil(Math.sqrt(n))+1 ; inx +=2 ){
			if( n % inx < 1){
				System.out.println("Not prime");
				return;
			}
		}
		System.out.println("Prime");
	}
}
