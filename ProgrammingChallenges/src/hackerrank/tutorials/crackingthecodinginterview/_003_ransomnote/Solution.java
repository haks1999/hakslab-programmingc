package hackerrank.tutorials.crackingthecodinginterview._003_ransomnote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 26..
 */
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();

		Map<String, Integer> magazine = new HashMap<>();
		for(int magazine_i=0; magazine_i < m; magazine_i++){
			String word = in.next();
			magazine.put(word, magazine.getOrDefault(word, 0)+1);
		}
		boolean poosible = true;
		for(int ransom_i=0; ransom_i < n; ransom_i++){
			String word = in.next();
			if( !magazine.containsKey(word) ){
				poosible = false;
				break;
			}
			if( magazine.get(word) < 1 ){
				poosible = false;
				break;
			}
			magazine.put(word, magazine.get(word)-1);
		}
		System.out.println( poosible?"Yes":"No");


	}
}
