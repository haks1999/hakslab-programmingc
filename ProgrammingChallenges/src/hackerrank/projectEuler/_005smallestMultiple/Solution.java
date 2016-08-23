package hackerrank.projectEuler._005smallestMultiple;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 1100413 on 2016. 8. 2..
 */
public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCasesCount = Integer.parseInt(scanner.nextLine());
		for (int inx = 0; inx < testCasesCount; inx++) {
			int inputNumber = Integer.parseInt(scanner.nextLine());

			System.out.println(getSmallestMultiple(inputNumber));

		}
	}

	static int getSmallestMultiple(int number){
		if( number < 2 ) return 1;
		if( number < 3 ) return 2;
		if( number < 4 ) return 6;

		for( int inx = (number/6 + 1)*6 ;; inx = inx + 6){
			int curNum = inx;
			int temp = number;

			boolean isEvenDivided = true;
			for( int jnx = number ; jnx > 0 ; jnx--){
				if( inx % jnx != 0){
					isEvenDivided = false;
					break;
				}
			}
			if( isEvenDivided ) return inx;
		}
	}


}
