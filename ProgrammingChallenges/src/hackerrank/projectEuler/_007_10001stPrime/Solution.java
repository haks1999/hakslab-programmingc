package hackerrank.projectEuler._007_10001stPrime;

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
			int inputNumber = Integer.parseInt(scanner.nextLine());

			System.out.println(getNthPrimeNumber(inputNumber));
		}
	}

	static List<Integer> primeNumbers = new ArrayList();
	static{
		primeNumbers.add(2);
		primeNumbers.add(3);
		primeNumbers.add(5);
	}

	static int getNthPrimeNumber(int nth){
		if(primeNumbers.size() > nth-1){
			return primeNumbers.get(nth-1);
		}

		int curIdx = primeNumbers.size()-1;
		int testNum = primeNumbers.get(curIdx)+2;

		while(true){

			boolean isPrimeNumber = true;
			for( int primeNumber : primeNumbers ){
				if( primeNumber > Math.sqrt(testNum)){
					break;
				}
				if( testNum % primeNumber == 0){
					isPrimeNumber = false;
					break;
				}
			}
			if( isPrimeNumber ){
				primeNumbers.add(testNum);
				if(++curIdx + 1 == nth){
					return testNum;
				}
			}
			testNum += 2;

		}

	}

}
