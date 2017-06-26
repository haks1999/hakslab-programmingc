package hackerrank.tutorials.crackingthecodinginterview._002_makinganagrams;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 26..
 */
public class Solution {

	public static int numberNeeded(String first, String second) {

		int[] firstCharArr = new int['z'-'a'+1];
		for( int inx = 0 ; inx < first.length() ; inx++ ){
			firstCharArr[first.charAt(inx)-'a']++;
		}
		int[] secondCharArr = new int['z'-'a'+1];
		for( int inx = 0 ; inx < second.length() ; inx++ ){
			secondCharArr[second.charAt(inx)-'a']++;
		}

		int delete = 0;
		for( int inx = 0 ; inx < firstCharArr.length ; inx++ ){
			delete += Math.abs(firstCharArr[inx] - secondCharArr[inx]);
		}
		return delete;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		System.out.println(numberNeeded(a, b));
	}

}
