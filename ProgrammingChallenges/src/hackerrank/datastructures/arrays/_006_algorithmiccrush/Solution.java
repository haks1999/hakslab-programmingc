package hackerrank.datastructures.arrays._006_algorithmiccrush;

import java.util.*;

/**
 * Created by 1100413 on 2017. 6. 21..
 */
public class Solution {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int arrayLength = in.nextInt();
		long[] arr = new long[arrayLength+1];

		long operationCount = in.nextLong();
		for( long inx = 0 ; inx < operationCount ; inx++ ){
			int startIndex = in.nextInt();
			int endIndex = in.nextInt();
			int numberToAdd = in.nextInt();
			arr[startIndex] += numberToAdd;
			if( endIndex+1 <= arrayLength ) arr[endIndex+1]-= numberToAdd;
		}

		long max = 0, addedDifference = 0; // int
		for (int i=1; i<=arrayLength; i++)
		{
			addedDifference = addedDifference + arr[i];
			if (max < addedDifference)
				max = addedDifference;
		}
		System.out.println(max);
	}
}
