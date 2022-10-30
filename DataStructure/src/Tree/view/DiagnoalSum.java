package Tree.view;

import java.util.LinkedList;
import java.util.Queue;

import Tree.BinaryTreeNode;
import Tree.TreeStructure;

public class DiagnoalSum {

	public static void main(String[] args) {
		BinaryTreeNode root = TreeStructure.treeStructure();
		// for root d=0 , left child = d + 1 , right child = d(sam as parent)
		diagnoalSum(root);
	}

	private static void diagnoalSum(BinaryTreeNode root) {
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		int sum = 0;
		while (!q.isEmpty()) {
			BinaryTreeNode temp = q.poll();
			if (temp == null) {
				System.out.println(" :- " + sum);
				q.offer(null);
				temp = q.poll();
				sum = 0;
				if (temp == null)
					break;
			}
			while (temp != null) {
				System.out.print(temp.data + " ");
				sum = sum + temp.data;
				if (temp.left != null)
					q.offer(temp.left);
				temp = temp.right;
			}
		}
	}
}
