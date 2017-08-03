package coursera.patternrecognition;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 8. 2..
 */
public class BruteCollinearPoints {
//	public BruteCollinearPoints(Point[] points)    // finds all line segments containing 4 points
//	public           int numberOfSegments()        // the number of line segments
//	public LineSegment[] segments()                // the line segments

	private LineSegment[] segments;
	private int numberOfSegments;

	public BruteCollinearPoints(Point[] points){
		if(points == null) throw new java.lang.IllegalArgumentException();
		for( Point point : points ) if(point == null) throw new java.lang.IllegalArgumentException();

		Arrays.sort(points);

		for( int i = 0; i < points.length-1 ; i++ ){
			if(points[i].compareTo(points[i+1]) == 0) throw new java.lang.IllegalArgumentException();
		}

		segments = new LineSegment[points.length];
		numberOfSegments = 0;
		int len = points.length;
		for( int p = 0 ; p < len-3; p++){
			for(int q = p+1; q < len-2; q++){
				if(points[p].compareTo(points[q]) == 0) throw new java.lang.IllegalArgumentException();
				double slopePq = points[p].slopeTo(points[q]);
				for(int r = q+1; r < len-1; r++){
					//System.out.println(points[q].toString() + points[r].toString());
					if(points[q].compareTo(points[r]) == 0) throw new java.lang.IllegalArgumentException();
					double slopeQr = points[q].slopeTo(points[r]);
					double slopeDiff = slopePq - slopeQr;
					//if(slopeDiff < 0) break;
					if(slopeDiff != 0 && !(slopePq==Double.POSITIVE_INFINITY && slopeQr==Double.POSITIVE_INFINITY)) continue;
					for(int s = r+1; s < len ; s++){
						if(points[r].compareTo(points[s]) == 0) throw new java.lang.IllegalArgumentException();
						double slopeRs = points[r].slopeTo(points[s]);
						slopeDiff = slopeQr - slopeRs;
						//if(slopeDiff < 0) break;
						if(slopeDiff != 0 && !(slopePq==Double.POSITIVE_INFINITY && slopeQr==Double.POSITIVE_INFINITY && slopeRs==Double.POSITIVE_INFINITY)) continue;
						addSegment(new LineSegment(points[p], points[s]));
						break;
					}
					//break;
				}
			}
		}
	}

	private void addSegment(LineSegment lineSegment){
		if(numberOfSegments+1 > segments.length){
			LineSegment[] newSegments = new LineSegment[numberOfSegments*2];
			for( int i = 0 ; i < numberOfSegments ; i++ ) newSegments[i] = segments[i];
			segments = newSegments;
		}
		segments[numberOfSegments++] = lineSegment;
	}

	public int numberOfSegments(){
		return numberOfSegments;
	}

	public LineSegment[] segments(){
		LineSegment[] segments = new LineSegment[numberOfSegments];
		for( int inx = 0 ; inx < numberOfSegments ; inx++ ){
			segments[inx] = this.segments[inx];
		}
		return segments;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Point[] points = new Point[n];
		for( int inx = 0 ; inx < n ; inx++ ){
			points[inx] = new Point(scanner.nextInt(), scanner.nextInt());
		}

		BruteCollinearPoints collinear = new BruteCollinearPoints(points);

		collinear.segments();

		// read the n points from a file
//		In in = new In(args[0]);
//		int n = in.readInt();
//		Point[] points = new Point[n];
//		for (int i = 0; i < n; i++) {
//			int x = in.readInt();
//			int y = in.readInt();
//			points[i] = new Point(x, y);
//		}
//
//		// draw the points
//		StdDraw.enableDoubleBuffering();
//		StdDraw.setXscale(0, 32768);
//		StdDraw.setYscale(0, 32768);
//		for (Point p : points) {
//			p.draw();
//		}
//		StdDraw.show();
//
//		// print and draw the line segments
//		BruteCollinearPoints collinear = new BruteCollinearPoints(points);
//		for (LineSegment segment : collinear.segments()) {
//			StdOut.println(segment);
//			segment.draw();
//		}
//		StdDraw.show();
	}


}
