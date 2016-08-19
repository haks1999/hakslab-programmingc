package hackerrank.sherlockAndValidString;

import java.util.*;

/**
 * Created by 1100413 on 2016. 7. 20..
 */
public class Solution {


	public static void main(String[] args) {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scanner = new Scanner(System.in);

		int[] countOfChars = new int['z'-'a'+1];

		String input = scanner.nextLine();
		for(int inx = 0 ; inx < input.length() ; inx++){
			countOfChars[input.charAt(inx)-'a']++;
		}

		Arrays.sort(countOfChars);

		//for( int inx = 0 ; inx < )

		if(countOfChars[countOfChars.length-3] > 0 ){
			System.out.println("NO");
		}else if(countOfChars[countOfChars.length-3] < 1 && countOfChars[countOfChars.length-2]>1){
			System.out.println("NO");
		}else{
			System.out.println("YES");
		}

	}

}
