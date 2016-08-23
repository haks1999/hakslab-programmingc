package hackerrank.projectEuler._002evenFibonacciNumbers;

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

			long befNum = 0;
			long curNum = 1;
			long sum = 0;
			while( curNum <= limit){
				if( curNum % 2 == 0 ) sum += curNum;
				long nextNum = curNum + befNum;
				befNum = curNum;
				curNum = nextNum;
			}
			System.out.println(sum);

		}


	}
}
