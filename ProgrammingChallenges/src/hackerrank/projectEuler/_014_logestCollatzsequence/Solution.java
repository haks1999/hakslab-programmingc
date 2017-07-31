package hackerrank.projectEuler._014_logestCollatzsequence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 1100413 on 2017. 7. 7..
 */
public class Solution {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		Map<Integer, Integer> map = new HashMap<>();
		map.put(1,1);
		int lastN = 1;
		int lastMax = 0;
		for( int inx = 0 ; inx < scanner.nextInt() ; inx++ ){
			int n = scanner.nextInt();
			for( int jnx = lastN ; jnx <= n ; jnx++ ){
				if( !map.containsKey(jnx) ){

					int num = jnx;
					int startTerm = 1;
					Stack<Integer> stack = new Stack();
					stack.push(num);
					while(true){
						if( num == 1 ) break;
						if( num % 2 == 0 ){
							num /= 2;
						}else{
							num = 3*num + 1;
						}
						if( map.containsKey(num) ){
							startTerm = map.get(num);
							break;
						}else{
							stack.push(num);
						}
					}

					int terms = 1;
					while(!stack.isEmpty()){
						map.put(stack.pop(), startTerm + terms++);
					}
					if( map.get(jnx) > lastMax ){
						lastMax = map.get(jnx);
						lastN = jnx;
					}

				}

			}
			System.out.println(lastN);
		}
	}
}
