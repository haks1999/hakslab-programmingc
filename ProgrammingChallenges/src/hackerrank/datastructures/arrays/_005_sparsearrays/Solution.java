package hackerrank.datastructures.arrays._005_sparsearrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 21..
 */
public class Solution {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int targetStringNumbers = Integer.parseInt(in.nextLine());
		Map<String, Integer> occur = new HashMap<>(targetStringNumbers);
		for( int inx = 0 ; inx < targetStringNumbers ; inx++ ){
			String targetString = in.nextLine();
			int currentOccur = occur.getOrDefault(targetString, 0);
			occur.put(targetString, currentOccur+1);
		}

		int queryStringNumbers = Integer.parseInt(in.nextLine());
		for( int inx = 0 ; inx < queryStringNumbers ; inx++ ){
			System.out.println(occur.getOrDefault(in.nextLine(), 0));
		}

	}
}
