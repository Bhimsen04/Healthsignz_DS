package CLL;

import LinkedList.ListNode;

public class Problem1_CLL_2Parts {
	public static void main(String[] args) {
		Problem1_CLL_2Parts obj = new Problem1_CLL_2Parts();

		CircularLinkedList cll = new CircularLinkedList();
		cll.addToHead(30);
		cll.addToHead(20);
		cll.addToHead(10);
		cll.addToTail(40);
		cll.addToTail(50);
		cll.addToTail(60);
		cll.addToTail(70);
		System.out.println(cll.toString() + " , " + cll.tail.getData() + " , " + cll.tail.getNext().getData());

		divideIntoTwoParts(cll.tail.getNext());

	}

	private static void divideIntoTwoParts(CLLNode head) {

		CLLNode fastptr = head, slowptr = head;
		while (fastptr.getNext() != head && fastptr.getNext().getNext() != head) {
			fastptr = fastptr.getNext().getNext();
			slowptr = slowptr.getNext();
		}
		CLLNode temp = slowptr.getNext();
		slowptr.setNext(head);
		if (fastptr.getNext().getNext() == head)
			fastptr = fastptr.getNext();
		fastptr.setNext(temp);
		slowptr = head;
		while (slowptr.getNext() != head) {
			System.out.print(slowptr.getData() + ",");
			slowptr = slowptr.getNext();
		}
		System.out.println(slowptr.getData() + "," + slowptr.getNext().getData());
		
		slowptr = temp;
		while (slowptr.getNext() != temp) {
			System.out.print(slowptr.getData() + ",");
			slowptr = slowptr.getNext();
		}
		System.out.println(slowptr.getData() + "," + slowptr.getNext().getData());
	}
}
