package hackerrank.projectEuler._006_sumSquareDifference;

import java.util.Scanner;

/**
 * Created by 1100413 on 2016. 8. 2..
 */
public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int testCasesCount = Integer.parseInt(scanner.nextLine());
		for (int inx = 0; inx < testCasesCount; inx++) {
			long inputNumber = Long.parseLong(scanner.nextLine());

			long sum = inputNumber * (inputNumber + 1l) / 2l;
			long sumOfSquared = inputNumber * (inputNumber + 1l) * (2l*inputNumber + 1l) / 6l;

			System.out.println(Math.abs(sumOfSquared-(sum*sum)));

		}
	}

}
