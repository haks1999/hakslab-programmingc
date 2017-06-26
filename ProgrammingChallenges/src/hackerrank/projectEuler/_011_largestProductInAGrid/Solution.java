package hackerrank.projectEuler._011_largestProductInAGrid;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 1100413 on 2016. 8. 2..
 */
public class Solution {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[][] grid = new int[23][26];
		for( int inx = 0 ; inx < 20 ; inx++ ){
			for( int jnx = 3 ; jnx < 23 ; jnx++){
				grid[inx][jnx] = scanner.nextInt();
			}
		}
		System.out.println(getMaxProductOfGrid(grid));
	}

	static long getMaxProductOfGrid(int[][] grid){
		long max = 0;

		for( int inx = 0 ; inx < 20 ; inx++ ){
			for( int jnx = 3 ; jnx < 23 ; jnx++ ){
				if( grid[inx][jnx] < 1 ) continue;

				long right = grid[inx][jnx] * grid[inx][jnx+1] * grid[inx][jnx+2] * grid[inx][jnx+3];
				if( right > max ) max = right;

				long down = grid[inx][jnx] * grid[inx+1][jnx] * grid[inx+2][jnx] * grid[inx+3][jnx];
				if( down > max ) max = down;

				long diaLeft = grid[inx][jnx] * grid[inx+1][jnx-1] * grid[inx+2][jnx-2] * grid[inx+3][jnx-3];
				if( diaLeft > max ) max = diaLeft;

				long diaRight = grid[inx][jnx] * grid[inx+1][jnx+1] * grid[inx+2][jnx+2] * grid[inx+3][jnx+3];
				if( diaRight > max ) max = diaRight;
			}
		}

		return max;

	}




}
