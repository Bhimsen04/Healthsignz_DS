package LinkedList;

import LinkedList.CopyListwithRandomPointer.Node;

public class Main {

	public static void main(String[] args) {
		CopyListwithRandomPointer pointer = new CopyListwithRandomPointer();
		Node n1 = pointer.new Node(1);
		Node head = n1;
		Node n2 = pointer.new Node(2);
		n1.next = n2;
		Node n3 = pointer.new Node(3);
		n1.next.next = n3;
		Node n4 = pointer.new Node(4);
		n1.next.next.next = n4;
		n1.random = n3;
		n2.random = n4;
		n3.random = n2;
		n4.random = n3;

		while (head != null) {
			System.out.print(head.val + " , ");
			System.out.println(head.random.val);
			head = head.next;
		}
		
		
	}

}
