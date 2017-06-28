package hackerrank.tutorials.crackingthecodinginterview._006_ataleoftwostacks;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 1100413 on 2017. 6. 26..
 */
public class Solution {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}

	public static class MyQueue<T>{

		private Stack<Integer> myStack;
		private Stack<Integer> myStackReverse;

		public MyQueue(){
			myStack = new Stack<>();
			myStackReverse = new Stack<>();
		}

		public void enqueue(int n){
			myStack.push(n);
		}

		public void dequeue(){
			if( myStackReverse.isEmpty() ){
				while(!myStack.isEmpty()){
					myStackReverse.push(myStack.pop());
				}
			}
			myStackReverse.pop();
		}

		public int peek(){
			if( myStackReverse.isEmpty() ){
				while(!myStack.isEmpty()){
					myStackReverse.push(myStack.pop());
				}
			}
			return myStackReverse.peek();
		}
	}

}
