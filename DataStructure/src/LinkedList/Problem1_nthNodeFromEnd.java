package LinkedList;

public class Problem1_nthNodeFromEnd {

	static ListNode head = null;

	public static void main(String[] args) {
		Problem1_nthNodeFromEnd obj = new Problem1_nthNodeFromEnd();
		LinkedList list = new LinkedList();
		ListNode listNode = new ListNode(30);
		list.insertAtBegin(listNode);
		listNode = new ListNode(20);
		list.insertAtBegin(listNode);
		listNode = new ListNode(10);
		list.insertAtBegin(listNode);
		listNode = new ListNode(40);
		list.insertAtEnd(listNode);
		list.insert(5, 0);
		head = list.getHead();
		System.out.println(list.toString());

		displayLinkedListFromEnd_Recursion(head);
		head = reverseLinkedList_Recursion(null, head);
		System.out.println(obj.toString());
		// ListNode node = obj.nthNodeFromEndOfLL_2(1);
		// if (node != null)
		// System.out.println(node.getData());
		// ListNode node = obj.nthNodeFromEndOfLL_Recursion(head, 1);
		// if (node != null)
		// System.out.println(node.getData());
	}

	private static void displayLinkedListFromEnd_Recursion(ListNode node) {

		if (node != null) {
			displayLinkedListFromEnd_Recursion(node.getNext());
			System.out.println(node.getData());
		}
	}

	static ListNode temp2 = null;

	private static ListNode reverseLinkedList_Recursion(ListNode current, ListNode node) {
		if (node == null)
			temp2 = current;
		else {
			reverseLinkedList_Recursion(node, node.getNext());
			node.setNext(current);
		}
		return temp2;
	}

	private static ListNode reverseLinkedList() {
		ListNode prev = null, next = null, current = head;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;

		}
		return prev;
	}

	int counter = 0;
	ListNode nd = null;

	public ListNode nthNodeFromEndOfLL_Recursion(ListNode node, int nth) {
		if (node != null) {
			nthNodeFromEndOfLL_Recursion(node.getNext(), nth);
			counter++;
			if (counter == nth)
				nd = node;
		}
		return nd;
	}

	public ListNode nthNodeFromEndOfLL_1(int nth) {
		ListNode temp2 = head;
		while (temp2 != null) {
			ListNode temp = temp2;
			int length = -1;
			while (temp != null) {
				length++;
				temp = temp.getNext();
			}
			if (length < nth - 1) {
				System.out.println("Fewer number of nodes in the list");
				return null;
			} else if (length == nth - 1) {
				return temp2;
			}
			temp2 = temp2.getNext();
		}
		return temp2;
	}

	public ListNode nthNodeFromEndOfLL_2(int nth) {
		ListNode listNode = head;
		int m = 0;
		while (listNode != null) {
			m++;
			listNode = listNode.getNext();
		}
		if (nth > m)
			System.out.println("Fewer number of nodes in the list");
		else if (nth > 0) {
			int n = m + 1 - nth;
			listNode = head;
			for (int i = 1; i < n; i++) {
				listNode = listNode.getNext();
			}
		}
		return listNode;
	}

	public ListNode nthNodeFromEndOfLL_3(int nth) {
		if (nth > 0) {
			ListNode pTemp = head, pNthNode = null;
			for (int i = 1; i < nth; i++) {
				if (pTemp == null)
					break;
				pTemp = pTemp.getNext();
			}
			while (pTemp != null) {
				if (pNthNode == null)
					pNthNode = head;
				else
					pNthNode = pNthNode.getNext();
				pTemp = pTemp.getNext();
			}
			return pNthNode;
		}
		return null;
	}

	public String toString() {
		String result = "[";
		if (head == null)
			return result + "]";
		result = result + head.getData();
		ListNode temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

}
