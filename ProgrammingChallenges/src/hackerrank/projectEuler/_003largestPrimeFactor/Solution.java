package hackerrank.projectEuler._003largestPrimeFactor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 1100413 on 2016. 8. 2..
 */
public class Solution {

	public static void main(String[] args){

		List<Long> primeNumbers = new ArrayList<>();
		primeNumbers.add(2l);
		primeNumbers.add(3l);
		primeNumbers.add(5l);
		primeNumbers.add(7l);

		for( long inx = 11 ; inx <= Math.sqrt(1000000000000l) ; inx++){
			if( inx % 2 == 0 || inx % 3 == 0 || inx % 5 == 0 || inx % 7 == 0){

			}else{
				boolean isPrimeNumber = true;
				for( int jnx = 4 ; jnx < primeNumbers.size() ; jnx++){
					long curPrimeNumber = primeNumbers.get(jnx);
					if( curPrimeNumber > Math.sqrt(inx)){
						break;
					}
					if( inx % curPrimeNumber == 0){
						isPrimeNumber = false;
						break;
					}
				}
				if( isPrimeNumber ) primeNumbers.add(inx);
			}
		}
		Scanner scanner = new Scanner(System.in);

		int testCasesCount = Integer.parseInt(scanner.nextLine());
		for( int inx = 0 ; inx < testCasesCount ; inx++){
			long inputNumber = Long.parseLong(scanner.nextLine());
			long maxPrimeNumber = 2;
			for( long primeNumber : primeNumbers ){
				if( primeNumber > inputNumber ) break;
				if( inputNumber % primeNumber == 0) {
					maxPrimeNumber = primeNumber;
				}
			}
			System.out.println(maxPrimeNumber);
		}
	}
}
