package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Traversals {
	public static void main(String[] args) {
		BinaryTreeNode binaryTreeNode = null;
		BinaryTreeNode root = new BinaryTreeNode(100);

		binaryTreeNode = new BinaryTreeNode(200);
		root.setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(300);
		root.setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(400);
		root.getLeft().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(500);
		root.getLeft().setRight(binaryTreeNode);

		binaryTreeNode = new BinaryTreeNode(600);
		root.getRight().setLeft(binaryTreeNode);
		binaryTreeNode = new BinaryTreeNode(700);
		root.getRight().setRight(binaryTreeNode);

		levelOrderTraversal(root);
	}

	static void levelOrderTraversal(BinaryTreeNode root) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> curr = new ArrayList<Integer>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp != null) {
				curr.add(temp.data);
				if (temp.left != null)
					q.offer(temp.left);
				if (temp.right != null)
					q.offer(temp.right);

			} else {
				//Ist way
				ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);
				res.add(c_curr);
				curr.clear();
				/* IInd way
				res.add(curr);*/
				curr = new ArrayList<Integer>();
				if (!q.isEmpty())
					q.offer(null);
			}
		}
		System.out.println(res);
//		for(ArrayList<Integer> l : res) {
//			for(int m : l ) {
//				System.out.println(m);
//			}
//		}

	}
}
