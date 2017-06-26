package hackerrank.projectEuler._008_largestProductInASeries;

import java.util.Scanner;

/**
 * Created by 1100413 on 2016. 8. 2..
 */
public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCasesCount = Integer.parseInt(scanner.nextLine());
		for (int inx = 0; inx < testCasesCount; inx++) {
			String[] inputNumbers = (scanner.nextLine().split(" "));
			long seriesLength = Long.parseLong(inputNumbers[1]);
			int[] digitArray = numberStringToIntegerArray(scanner.nextLine());

			System.out.println(getMaxProduct(digitArray, seriesLength));
		}
	}

	static int[] numberStringToIntegerArray(String number){
		int[] intArray = new int[number.length()];
		for (int i = 0; i < number.length(); i++) {
			intArray[i] = Character.digit(number.charAt(i), 10);
		}
		return intArray;
	}

	static long getMaxProduct(int[] digitArray, long seriesLength){

		long possibleMax = (long)Math.pow(9, seriesLength);
		long max = 0;
		for( int inx = 0 ; inx < digitArray.length - seriesLength ; inx++){
			long currentMax = digitArray[inx];
			for( int jnx = inx+1 ; jnx < inx + seriesLength ; jnx++){
				currentMax *= digitArray[jnx];
				if(currentMax < 1) break;
			}
			if(max < currentMax){
				max = currentMax;
			}
			if( max == possibleMax){
				break;
			}
		}
		return max;
	}

}
