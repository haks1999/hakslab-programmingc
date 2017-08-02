package coursera.queue;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by 1100413 on 2017. 7. 31..
 */
public class Permutation {

	public static void main(String[] args){
		RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
		for(String inputStr : StdIn.readAllStrings() ){
			randomizedQueue.enqueue(inputStr);
		}

		for( int inx = 0 ; inx < Integer.parseInt(args[0]) ; inx++ ){
			StdOut.println(randomizedQueue.dequeue());
		}
	}
}
