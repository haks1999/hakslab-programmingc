package hackerrank.projectEuler._004largestPalindromeProduct;

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
			System.out.println(getMaxPalindromeAndProductionOfNumbersNumber(inputNumber));
		}
	}

	static int getMaxPalindromeAndProductionOfNumbersNumber(int number){

		while( number > 10000){
			if( isPalindromeNumber(number) && isProductOfNumbers(number)){
				return number;
			}else{
				number--;
			}
		}
		return number;
	}

	static boolean isPalindromeNumber(int number){
		Stack<Integer> stack = new Stack();
		int temp = number;
		for( int inx = 0 ; inx < 6 ; inx++){
			int curNum = temp%10;
			if( inx > 2 ){
				if( stack.pop() != curNum ){
					return false;
				}
			}else{
				stack.push(curNum);
			}
			temp = temp/10;
		}
		return true;
	}

	static boolean isProductOfNumbers(int number){
		int start = 100;
		while( start < 1000){
			if( number % start == 0 ){
				if( number / start < 1000 && number/start > 99)
				return true;
			}
			start++;
		}
		return false;

	}
}
