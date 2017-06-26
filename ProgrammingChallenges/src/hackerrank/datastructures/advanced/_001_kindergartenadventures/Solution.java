package hackerrank.datastructures.advanced._001_kindergartenadventures;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 1100413 on 2017. 6. 22..
 */
public class Solution {

	public static void main(String[] args){

//		int[] a = {2468};
//		int[] m = {8642};
//		System.out.println(minimumMoves(a, m));

		//int[] numbs = {1,3};
		//cardinalitySort(numbs);

		frequency("1(2)23(3)");

	}

	static int[] frequency(String s) {

		int[] result = new int['z'-'a'+1];

		int cursor = s.length()-1;

		int multiply = 1;
		while(cursor > -1){
			char currentChar = s.charAt(cursor);
			if( currentChar == ')'){
				currentChar = s.charAt(--cursor);
				int multiplyNumberLength = 0;
				while( currentChar != '('){
					currentChar = s.charAt(cursor--);
					multiplyNumberLength++;
				}
				multiply = Integer.valueOf(s.substring(cursor+2, cursor+1+multiplyNumberLength));
				continue;
			}

			int targetIndex= Character.getNumericValue(currentChar);
			if( currentChar == '#'){
				targetIndex = Integer.valueOf(s.substring(cursor-2, cursor));
				cursor -= 2;
			}

			result[targetIndex-1] += multiply;
			multiply = 1;
			cursor--;
		}

		return result;

	}




	static int minimumMoves(int[] a, int[] m) {

		int move = 0;
		for( int inx = 0 ; inx < a.length; inx++ ){
			int tens = 1;
			for( int jnx = 1 ; jnx <= String.valueOf(a[inx]).length() ; jnx++ ){
				int remainderA = a[inx]%(10*tens) / tens;
				int remainderM = m[inx]%(10*tens) / tens;
				move += Math.abs(remainderA-remainderM);
				tens *= 10;
			}
		}
		return move;

	}



	static int[] cardinalitySort(int[] nums) {

		Map<Integer,List<Integer>> cadinalMap = new HashMap<>();
		for( int inx = 0 ; inx < nums.length ; inx++ ){
			int binaryTotal = 0;
			int targetNum = nums[inx];
			while(targetNum > 0) {
				binaryTotal += targetNum % 2;
				targetNum /= 2;
			}
			if( cadinalMap.containsKey(binaryTotal) ){
				cadinalMap.get(binaryTotal).add(nums[inx]);
			}else{
				List<Integer> numbersByBinaryTotal = new ArrayList<>();
				numbersByBinaryTotal.add(nums[inx]);
				cadinalMap.put(binaryTotal, numbersByBinaryTotal);
			}
		}

		List<Integer> sortedNumberList = new ArrayList<>(nums.length);
		TreeMap<Integer,List<Integer>> cadinalTreeMap = new TreeMap<>(cadinalMap);
		for (Map.Entry<Integer,List<Integer>> entry : cadinalTreeMap.entrySet()) {
			Collections.sort(cadinalTreeMap.get(entry.getKey()));
			sortedNumberList.addAll(cadinalTreeMap.get(entry.getKey()));
		}

		return sortedNumberList.stream().mapToInt(num->num).toArray();
	}


}
