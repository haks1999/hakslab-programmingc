package hackerrank.projectEuler._001mutiplesOf3And5;

import java.util.Scanner;

/**
 * Created by 1100413 on 2016. 8. 2..
 */
public class Solution {

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);

		int testCasesCount = Integer.parseInt(scanner.nextLine());
		for( int inx = 0 ; inx < testCasesCount ; inx++){
			long limit = Long.parseLong(scanner.nextLine());
			if(limit > 0) limit--;

			long maxIndexOfThree = limit/3;
			long sumOfThree = 3* maxIndexOfThree * ( maxIndexOfThree + 1) /2;

			long maxIndexOfFive = limit/5;
			long sumOfFive = 5* maxIndexOfFive * ( maxIndexOfFive + 1) /2;

			long maxIndexOfFifteen = limit/15;
			long sumOfFifteen = 15* maxIndexOfFifteen * ( maxIndexOfFifteen + 1) /2;

			System.out.println(sumOfFive + sumOfThree - sumOfFifteen);
		}


	}
}
