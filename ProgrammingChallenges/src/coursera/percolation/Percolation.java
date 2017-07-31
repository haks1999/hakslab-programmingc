package coursera.percolation;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 7. 26..
 */
public class Percolation {

	private WeightedQuickUnionUF grid;
	private boolean[] opened;
	private int n;
	private int openSites;
	private int totalSize;

	public Percolation(int n) {
		if (n <= 0) throw new IllegalArgumentException();
		totalSize = n*n + 2;
		grid = new WeightedQuickUnionUF(totalSize);
		opened = new boolean[totalSize];
		this.n = n;
		openSites = 0;
		opened[0] = true;
		opened[opened.length-1] = true;
	}

	public void open(int row, int col) {
		if (row < 0 || row > n || col < 0 || col > n) throw new IllegalArgumentException();
		if (isOpen(row, col)) return;
		openSites++;
		int id = getId(row, col);
		opened[id] = true;

		if (isOpen(row-1, col)) {
			grid.union(id, getId(row-1, col));
		}
		if (isOpen(row, col-1)) {
			grid.union(id, getId(row, col-1));
		}
		if (isOpen(row, col+1)) {
			grid.union(id, getId(row, col+1));
		}
		if (isOpen(row+1, col)) {
			grid.union(id, getId(row+1, col));
		}

		if (id < n+1) {
			grid.union(0, id);
		}
		if (id > totalSize - n) {
			grid.union(id, totalSize-1);
		}
	}

	private int getId(int row, int col) {
		return (row-1)*n + (col-1) + 1;
	}

	public boolean isOpen(int row, int col) {
		if (row < 1 || col < 1 || row > n || col > n) return false;
		int id = getId(row, col);
		return id >= 0 && opened[id];
	}

	public boolean isFull(int row, int col) {
		if (!isOpen(row, col)) return false;
		return grid.connected(0, getId(row, col));
	}

	public int numberOfOpenSites() {
		return openSites;
	}

	public boolean percolates() {
		return grid.connected(0, totalSize-1);
	}

	public static void main(String[] args) throws  Exception{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		Percolation percolation = new Percolation(n);
		for( int inx = 0 ; inx < 18 ; inx++ ){
			int row = scanner.nextInt();
			int col = scanner.nextInt();
			percolation.open(row, col);
			boolean isOpen = percolation.isOpen(row, col);
			boolean isPercolation = percolation.percolates();
			boolean isFull = percolation.isFull(row, col);
			if( isFull && !isOpen ) throw new Exception("error");
			int openSites = percolation.numberOfOpenSites();

		}
	}

}
