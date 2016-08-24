package hackerrank.projectEuler._010summationOfPrimes;

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
			System.out.println(getSumOfPrimes(inputNumber));

		}
	}

	static List<Long> primeNumbers = new ArrayList();
	static List<Long> sumOfPrimeNumbers = new ArrayList();
	static{
		primeNumbers.add(2l);
		primeNumbers.add(3l);
		primeNumbers.add(5l);
		sumOfPrimeNumbers.add(2l);
		sumOfPrimeNumbers.add(5l);
		sumOfPrimeNumbers.add(10l);
	}

	static long getSumOfPrimes(int number){
		if(number < 2) return 0;
		for( int inx = 0 ; inx < primeNumbers.size() ; inx++ ){
			long primeNumber = primeNumbers.get(inx);
			if(primeNumber == number){
				return sumOfPrimeNumbers.get(inx);
			}else if(primeNumber > number){
				return sumOfPrimeNumbers.get(inx-1);
			}
		}
		generatePrimeNumbers(number);

		return sumOfPrimeNumbers.get(sumOfPrimeNumbers.size()-1);
	}

	static void generatePrimeNumbers(int number){
		int curIdx = primeNumbers.size()-1;
		long testNum = primeNumbers.get(curIdx)+2;

		while(testNum < number || testNum == number){

			boolean isPrimeNumber = true;
			for( long primeNumber : primeNumbers ){
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
				sumOfPrimeNumbers.add(sumOfPrimeNumbers.get(sumOfPrimeNumbers.size()-1) + testNum);
			}
			testNum += 2;
		}
	}


}
