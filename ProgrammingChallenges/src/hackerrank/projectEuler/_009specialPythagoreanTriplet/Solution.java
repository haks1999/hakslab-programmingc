package hackerrank.projectEuler._009specialPythagoreanTriplet;

import java.util.Scanner;

/**
 * Created by 1100413 on 2016. 8. 2..
 */
public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCasesCount = Integer.parseInt(scanner.nextLine());
		for (int inx = 0; inx < testCasesCount; inx++) {
			int inputNumber = Integer.parseInt(scanner.nextLine());
			System.out.println(getMax(inputNumber));

		}
	}

	static long getMax(int number){
		if( number < 5 ) return -1;
		long max = -1;
		boolean isGoing = true;

		for( int varA = 1; varA < number && isGoing; varA++){
			for( int varB = varA+1; varB < number; varB++){
				int varC = number - varA - varB;
				if( varC == varA || varA > varC){
					isGoing = false;
					break;
				}
				if( varC == varB || varB > varC){
					break;
				}
				if( varA*varA + varB*varB == varC * varC ){
					if( varA*varB*varC > max){
						max = varA*varB*varC;
					}
				}
			}
		}
		return max;
	}



}
