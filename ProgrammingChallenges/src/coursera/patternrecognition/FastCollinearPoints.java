package coursera.patternrecognition;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 8. 2..
 */
public class FastCollinearPoints {
//	public FastCollinearPoints(Point[] points)     // finds all line segments containing 4 or more points
//	public           int numberOfSegments()        // the number of line segments
//	public LineSegment[] segments()                // the line segments

	private int numberOfSegments = 0;
	private LineSegment[] segments;

	public FastCollinearPoints(Point[] points) {
		if (points == null) throw new java.lang.IllegalArgumentException();
		for( Point point : points ) if(point == null) throw new java.lang.IllegalArgumentException();
		Arrays.sort(points);

		for( int i = 0; i < points.length-1 ; i++ ){
			if(points[i].compareTo(points[i+1]) == 0) throw new java.lang.IllegalArgumentException();
		}

		segments = new LineSegment[points.length];
		for (int p = 0; p < points.length - 3; p++) {
			Arrays.sort(points, p+1, points.length, points[p].slopeOrder());
			double befSlope = points[p].slopeTo(points[p+1]);
			int cnt = 1;
			int lastQ = p + 2;
			for (int q = p + 2; q < points.length; q++) {
				double curSlope = points[p].slopeTo(points[q]);
				if (curSlope == befSlope) {
					cnt++;
					lastQ = q;
				}else{
					if (cnt >= 3) {
						addSegment(new LineSegment(points[p], points[q-1]));
					}
					cnt = 1;
					befSlope = curSlope;
				}
			}
			if (cnt >= 3) {
				addSegment(new LineSegment(points[p], points[lastQ]));
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

	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Point[] points = new Point[n];
		for( int inx = 0 ; inx < n ; inx++ ){
			points[inx] = new Point(scanner.nextInt(), scanner.nextInt());
		}

		FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);

	}

}
