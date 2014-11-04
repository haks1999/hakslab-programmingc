package spoj._4_onp_transformtheexpression;

import java.util.Scanner;
import java.util.Stack;

class ONP {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = new String();
		int i;
		i = sc.nextInt();

		while (i > 0) {
			str = sc.next();
			
			String rnp = new String();
			int len = str.length();
			Stack<Character> stk = new Stack<Character>();
			char c;
			for (int k = 0; k < len; k++) {
				c = str.charAt(k);
				switch (c) {
				case '(':
					break;

				case '+':
					stk.push(c);
					break;

				case '-':
					stk.push(c);
					break;

				case '*':
					stk.push(c);
					break;

				case '/':
					stk.push(c);
					break;

				case '^':
					stk.push(c);
					break;

				case ')':
					rnp = rnp + stk.pop();
					break;

				default:
					rnp = rnp + c;
					break;
				}
			}
			System.out.println(rnp);
			i--;
		}
		sc.close();
	}
}