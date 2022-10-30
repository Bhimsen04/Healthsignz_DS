package com.practice;

import java.util.Stack;

public class Practice {
	
void inorderTraversal(Node root) {
	Stack<Node> s = new Stack<>();
	
	while(true) {
		while(root!=null) {
			s.push(root);
			root = root.left;
		}
		
		if(!s.isEmpty()) {
		Node parent = s.pop();
		
		System.out.println(parent.data);
		root = parent.right;
		}
		else
		{
			break;
		}
	}
}
	
}
