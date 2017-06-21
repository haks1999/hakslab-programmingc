package hackerrank.projectEuler._011largestProductInAGrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 1100413 on 2016. 8. 2..
 */
public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		//int testCasesCount = Integer.parseInt(scanner.nextLine());
		//for (int inx = 0; inx < testCasesCount; inx++) {

			int[][] grid = new int[20][20];
			for( int knx = 0 ; knx < 20 ; knx++ ){
				String[] rowInStr = scanner.nextLine().split(" ");
				for( int jnx = 0 ; jnx < 20 ; jnx++){
					grid[knx][jnx] = Integer.parseInt(rowInStr[jnx]);
				}
			}
		getMaxProductOfGrid(grid);
		//}
	}

	static long getMaxProductOfGrid(int[][] grid){
		long max = 0;
		for(int[] row : grid){
			int[] copiedRow = Arrays.copyOf(row, row.length);
			max = getMaxProductOfFour(copiedRow, max);
		}
		for(int inx = 0 ; inx < 20 ; inx++){
			int[] col = new int[20];
			for( int jnx = 0 ; jnx < 20 ; jnx++){
				col[jnx] = grid[jnx][inx];
			}
			max = getMaxProductOfFour(col, max);
		}
		for(int inx = 3; inx < 20; inx++){
			int[] diagonal = new int[inx+1];
			int rowIdx = inx;
			int colIdx = inx;
			while(rowIdx > -1 && colIdx < 20){
				diagonal[rowIdx] = grid[rowIdx--][colIdx++];
			}
			max = getMaxProductOfFour(diagonal, max);
		}
		return max;
	}

	static long getMaxProductOfFour(int[] arr, long max){
		Arrays.sort(arr);
		long curMax =  arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3] * arr[arr.length-4];
		if(curMax > max){
			return curMax;
		}else{
			return max;
		}
	}




}
