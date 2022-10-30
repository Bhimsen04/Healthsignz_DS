package LinkedList;

public class Problem5_Reverse_Blocks {
	static ListNode head = null;

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode listNode = new ListNode(130);
		list.insertAtBegin(listNode);
		listNode = new ListNode(120);
		list.insertAtBegin(listNode);
		listNode = new ListNode(110);
		list.insertAtBegin(listNode);
		listNode = new ListNode(100);
		list.insertAtBegin(listNode);
		listNode = new ListNode(90);
		list.insertAtBegin(listNode);
		listNode = new ListNode(10);
		list.insertAtBegin(listNode);
		list.insert(8, 0);
		list.insert(5, 0);
		head = list.getHead();
		System.out.println(list.toString());
		// ListNode res = reverseKBlocks_Recursive(head, 3);
		// while (res != null) {
		// System.out.print(res.getData() + ",");
		// res = res.getNext();
		// }

		ListNode node = findNodeFromEnd(head, 8);
		System.out.println(node.getData());
	}

	private static ListNode findNodeFromEnd(ListNode head, int i) {
		int c = 0;
		ListNode tmp = null;
		if (head != null && head.getNext() != null)
			tmp = head.getNext();
		while (head != null) {
			head = head.getNext();
			if (c % i == 0 && head != null)
				tmp = head;
			c++;
		}
		if (i >= c)
			tmp = null;
		return tmp;
	}

	private static ListNode reverseKBlocks(ListNode head, int k) {

		ListNode current = head;
		ListNode prevTail = null;
		ListNode prevCurrent = head;
		while (current != null) {
			int count = k;
			ListNode tail = null;
			while (current != null && count > 0) {
				ListNode next = current.getNext();
				current.setNext(tail);
				tail = current;
				current = next;
				count--;
			}
			if (prevTail != null) {
				prevTail.setNext(tail);
			} else {
				head = tail;
			}
			prevTail = prevCurrent;
			prevCurrent = current;
		}
		return head;
	}

	private static ListNode reverseKBlocks_Recursive(ListNode head, int k) {

		ListNode current = head;
		ListNode next = null;
		ListNode prev = null;
		int count = k;

		while (current != null && count > 0) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
			count--;
		}
		if (next != null) {
			head.setNext(reverseKBlocks_Recursive(next, k));
		}
		return prev;
	}
}
