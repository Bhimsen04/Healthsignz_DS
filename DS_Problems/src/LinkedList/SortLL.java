package LinkedList;

public class SortLL {

	// https://leetcode.com/problems/sort-list/

	public class ListNode {
		public int data;
		public ListNode next;

		public ListNode(int data) {
			this.data = data;
		}
	}

	public ListNode insertNodeAtHead(ListNode head, int data) {
		ListNode node = new ListNode(data);
		node.next = head;
		return node;
	}

	public void print(ListNode head) {
		if (head == null)
			System.out.println("No LinkedList is there");
		else {
			while (head != null) {
				System.out.print(head.data + " ");
				head = head.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SortLL list = new SortLL();
		ListNode head = null;
		head = list.insertNodeAtHead(null, 3);
		head = list.insertNodeAtHead(head, 9);
		head = list.insertNodeAtHead(head, 5);
		head = list.insertNodeAtHead(head, 6);
		list.print(head);
		// int length = list.length(head);
		// bubbleSort(list, head, length);
		head = list.mergeSort(head);
		list.print(head);
	}

	private ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode mid = getMiddle_floor(head);
		ListNode rightHead = mid.next;
		mid.next = null;
		ListNode left = mergeSort(head);
		ListNode right = mergeSort(rightHead);
		return mergeLists(left, right);
	}

	public ListNode getMiddle_floor(ListNode head) {
		ListNode slowPointer = head, fasterPointer = null;
		if (head != null && head.next != null)
			fasterPointer = head.next;
		while (fasterPointer != null && fasterPointer.next != null) {
			slowPointer = slowPointer.next;
			fasterPointer = fasterPointer.next.next;
		}
		return slowPointer;
	}

	public ListNode mergeLists(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(-1);
		ListNode head = dummy;
		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {
				dummy.next = head1;
				head1 = head1.next;
			} else {
				dummy.next = head2;
				head2 = head2.next;
			}
			dummy = dummy.next;
		}
		if (head1 != null)
			dummy.next = head1;
		else if (head2 != null)
			dummy.next = head2;
		return head.next;
	}

	private static void bubbleSort(Customized_LinkedList list, ListNode head, int length) {
		for (int i = 0; i < length - 1; i++) {
			ListNode previous = null;
			ListNode current = head;
			ListNode next = head.next;
			for (int j = 0; j < length - i - 1; j++) {
				if (current.data > next.data) {
					if (j == 0) {
						current.next = next.next;
						next.next = current;
						head = next;
					} else {
						previous.next = next;
						current.next = next.next;
						next.next = current;
					}
					previous = next;
					next = current.next;
				} else {
					previous = current;
					current = current.next;
					next = current.next;
				}
			}
		}
		// list.print(head);
	}

}
