package hackerrank.tutorials.crackingthecodinginterview._013_connectedcellinagrid;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 29..
 */
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int row = in.nextInt() + 2;
		int col = in.nextInt() + 2;
		int grid[][] = new int[row][col];
		for(int grid_i=1; grid_i < row-1; grid_i++){
			for(int grid_j=1; grid_j < col-1; grid_j++){
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		int max = 0;
		for( int inx = 1 ; inx < row-1 ; inx++ ){
			for( int jnx = 1; jnx < col-1; jnx++ ){
				if( grid[inx][jnx] < 1) continue;
				int count =  countCell(grid, inx, jnx);
				if( max < count){
					max = count;
				}
			}
		}
		System.out.println(max);
	}

	static int countCell(int[][] grid, int x, int y){
		if(grid[x][y] < 1) return 0;
		int thisCount = grid[x][y] < 0 ? 0:1;
		grid[x][y] = -1;
		return thisCount + countCell(grid, x, y-1) + countCell(grid, x, y+1)
				+ countCell(grid, x-1, y-1) + countCell(grid, x-1, y) + countCell(grid, x-1, y+1)
				+ countCell(grid, x+1, y-1) + countCell(grid, x+1, y) + countCell(grid, x+1, y+1);
	}

}
