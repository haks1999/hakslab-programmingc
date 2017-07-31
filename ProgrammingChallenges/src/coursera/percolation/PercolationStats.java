package coursera.percolation;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by 1100413 on 2017. 7. 26..
 */
public class PercolationStats {

	private double[] openedRatio;
	public PercolationStats(int n, int trials) {
		if(n < 1 || trials < 1) throw new IllegalArgumentException();
		openedRatio = new double[trials];
		for( int inx = 0 ; inx < trials ; inx++ ){
			Percolation percolation = new Percolation(n);
			while( !percolation.percolates() ){
				percolation.open(StdRandom.uniform(1, n+1), StdRandom.uniform(1, n+1));
			}
			openedRatio[inx] = percolation.numberOfOpenSites()/(double)(n*n);
		}
	}

	public double mean(){
		return StdStats.mean(openedRatio);
	}
	public double stddev(){
		return StdStats.stddev(openedRatio);
	}
	public double confidenceLo(){
		return mean() - 1.96*stddev()/Math.sqrt(openedRatio.length);
	}
	public double confidenceHi(){
		return mean() + 1.96*stddev()/Math.sqrt(openedRatio.length);
	}

	public static void main(String[] args) {
		PercolationStats percolationStats = new PercolationStats(2, 1000);
		StdOut.printf("mean = %f\n", percolationStats.mean());
		StdOut.printf("stddev = %f\n", percolationStats.stddev());
	}

}
