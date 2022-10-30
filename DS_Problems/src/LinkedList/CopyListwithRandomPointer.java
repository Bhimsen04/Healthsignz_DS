package LinkedList;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CopyListwithRandomPointer {

	// https:// leetcode.com/problems/copy-list-with-random-pointer/
	public class Node {
		public int val;
		public Node next;
		public Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Node temp = head;
		HashMap<Node, Node> map1 = new HashMap<Node, Node>();
		HashMap<Node, Node> map2 = new HashMap<Node, Node>();

		Node newNode = new Node(temp.val);
		Node copyHead = newNode;

		while (temp != null) {
			Node nextNode = null;
			if (temp.next != null) {
				nextNode = new Node(temp.next.val);
				newNode.next = nextNode;
			}
			map1.put(temp, temp.random);
			map2.put(temp, newNode);
			newNode = nextNode;
			temp = temp.next;
		}
		Set<Entry<Node, Node>> entry1 = map1.entrySet();
		for (Entry<Node, Node> entry : entry1) {
			Node copyRandomPointer = map2.get(entry.getValue());
			map2.get(entry.getKey()).random = copyRandomPointer;
		}
		return copyHead;
	}

	public Node copyRandomList2(Node head) {
		if (head == null)
			return null;
		// Step 1
		Node temp = head;
		while (temp != null) {
			Node nextNode = temp.next;
			Node newNode = new Node(temp.val);
			temp.next = newNode;
			temp.next.next = nextNode;
			temp = nextNode;
		}

		// Step 2
		temp = head;
		while (temp != null) {
			if (temp.next != null && temp.random != null)
				temp.next.random = temp.random.next;
			temp = temp.next.next;
		}
		// Step 3
		temp = head.next;
		Node result = temp;
		while (temp != null && temp.next != null) {
			Node n = temp.next;
			temp.next = temp.next.next;
			temp = temp.next;
			head.next = n;
			head = head.next;
		}
		head.next = null;
		return result;
	}

	public static void main(String[] args) {
		CopyListwithRandomPointer pointer = new CopyListwithRandomPointer();
		Node n1 = pointer.new Node(7);
		Node head = n1;
		Node n2 = pointer.new Node(13);
		n1.next = n2;
		Node n3 = pointer.new Node(11);
		n1.next.next = n3;
		Node n4 = pointer.new Node(10);
		n1.next.next.next = n4;
		Node n5 = pointer.new Node(1);
		n1.next.next.next.next = n5;
		n1.random = n5.next;
		n2.random = n1;
		n3.random = n5;
		n4.random = n3;
		n5.random = n1;

		Node temp = head;
		while (temp != null) {
			System.out.print(temp + " , " + temp.val + " , ");
			if (temp.random != null)
				System.out.println(temp.random.val);
			else
				System.out.println();
			temp = temp.next;
		}
		// System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
		// Node first = pointer.copyRandomList(head);
		// while (first != null) {
		// System.out.print(first + " , " + first.val + " , ");
		// if (first.random != null)
		// System.out.println(first.random.val);
		// else
		// System.out.println();
		// first = first.next;
		// }
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////");
		Node second = pointer.copyRandomList2(head);
		while (second != null) {
			System.out.print(second + " , " + second.val + " , ");
			if (second.random != null)
				System.out.println(second.random.val);
			else
				System.out.println();
			second = second.next;
		}
	}
}
