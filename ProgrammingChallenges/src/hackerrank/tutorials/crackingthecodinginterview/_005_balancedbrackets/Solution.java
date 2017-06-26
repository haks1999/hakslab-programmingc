package hackerrank.tutorials.crackingthecodinginterview._005_balancedbrackets;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 1100413 on 2017. 6. 26..
 */
public class Solution {

	public static boolean isBalanced(String expression) {

		Stack<Character> stack = new Stack<>();
		for( int inx = 0 ; inx < expression.length() ; inx++ ){
			char currentChar = expression.charAt(inx);
			if( currentChar == '(' || currentChar == '{' || currentChar == '['){
				stack.push(currentChar);
				continue;
			}

			if(stack.isEmpty()) return false;
			char poppedChar = stack.pop();
			if( currentChar == ')' ){
				if( poppedChar != '(' ) return false;
			}else if( currentChar == '}' ){
				if( poppedChar != '{' ) return false;
			}else if( currentChar == ']'){
				if( poppedChar != '[') return false;
			}
		}

		return stack.isEmpty();

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
		}
	}

}
