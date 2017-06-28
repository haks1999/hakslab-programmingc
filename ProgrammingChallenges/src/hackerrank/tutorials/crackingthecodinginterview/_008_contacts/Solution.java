package hackerrank.tutorials.crackingthecodinginterview._008_contacts;

import java.util.Scanner;

/**
 * Created by 1100413 on 2017. 6. 28..
 */
public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node root = new Node();
		for(int a0 = 0; a0 < n; a0++){
			String op = in.next();
			String contact = in.next();
			if( op.equals("add") ){
				fillNode(root, contact);
			}else if( op.equals("find") ){
				System.out.println(findNode(root, contact));
			}
		}
	}

	public static void fillNode(Node node, String contact){
		Node targetNode = node.children[contact.charAt(0)-'a'];
		if( targetNode == null ){
			targetNode = new Node();
			node.children[contact.charAt(0)-'a'] = targetNode;
		}
		targetNode.count++;
		if( contact.length() < 2 ) return;
		fillNode(targetNode, contact.substring(1));
	}

	public static int findNode(Node node, String partial){
		Node targetNode = node.children[partial.charAt(0)-'a'];
		if( targetNode == null ) return 0;
		if( partial.length() < 2 ) return targetNode.count;
		return findNode(targetNode, partial.substring(1));
	}

	public static class Node{
		int count;
		Node[] children;

		public Node(){
			count = 0;
			children = new Node['z'-'a'+1];
		}
	}

}
