package hackerrank.projectEuler._003largestPrimeFactor;

import java.util.ArrayList;
import java.util.List;
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

			long curNum = inputNumber;
			long startNum = 2;

			while (true) {
				if (curNum == 1) {
					break;
				}
				if (curNum % startNum == 0) {
					curNum = curNum / startNum;
				} else {
					startNum++;
					if (startNum > 3) {
						while (startNum % 2 == 0 || startNum % 3 == 0) {
							startNum++;
						}
						if (startNum > Math.sqrt(curNum)) {
							startNum = curNum;
							break;
						}
					}
				}
			}

			System.out.println(startNum);
		}
	}
}
