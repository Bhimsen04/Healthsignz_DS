package LinkedList;

public class Customized_LinkedList {

	// https://www.hackerrank.com/domains/data-structures?filters%5Bsubdomains%5D%5B%5D=linked-lists
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

	public ListNode insertNodeAtTail(ListNode head, int data) {
		ListNode node = new ListNode(data);
		ListNode temp = head;
		if (temp == null)
			return node;
		while (temp.next != null)
			temp = temp.next;
		temp.next = node;
		return head;
	}

	public ListNode insertNodeAtPosition(ListNode head, int data, int position) {
		ListNode node = new ListNode(data);
		// IF No node in the list
		if (head == null)
			return node;

		// IF only one node in the list
		if (position == 0) {
			node.next = head;
			return node;
		}

		// IF more than one node in the list
		int counter = 0;
		ListNode previousNode = head;
		while (previousNode != null && counter < position - 1) {
			previousNode = previousNode.next;
			counter++;
		}
		node.next = previousNode.next;
		previousNode.next = node;
		return head;
	}

	public ListNode insertInSortedList(ListNode head, int data) {
		ListNode node = new ListNode(data);
		ListNode previous = null, next = head;
		while (next != null && next.data < data) {
			previous = next;
			next = next.next;
		}
		if (previous == null) {
			node.next = head;
			return node;
		} else {
			previous.next = node;
			node.next = next;
			return head;
		}
	}

	// 1-2-3-4-5
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

	public void printRecursively(ListNode head) {
		if (head != null) {
			System.out.print(head.data + " ");
			printRecursively(head.next);
		} else
			System.out.println();
	}

	public int length(ListNode head) {
		int counter = 0;
		while (head != null) {
			counter++;
			head = head.next;
		}
		return counter;
	}

	public void printReverseRecursively(ListNode head) {
		if (head != null) {
			printReverseRecursively(head.next);
			System.out.print(head.data + " ");
		}
	}

	public ListNode distinctElements(ListNode head) {
		ListNode headCopy = head;
		while (head != null) {
			ListNode temp = head;
			while (head.next != null && head.next.data == temp.data)
				head = head.next;
			temp.next = head.next;
			head = head.next;
		}
		return headCopy;
	}

	public ListNode distinctElements2(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			while (temp.next != null && temp.data == temp.next.data)
				temp.next = temp.next.next;
			temp = temp.next;
		}
		return head;
	}

	public ListNode deleteFirstOccurence(ListNode head, int data) {
		ListNode previous = null, current = head;
		while (current != null && current.data != data) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			ListNode temp = current.next;
			current.next = null;
			return temp;
		} else if (current != null) {
			previous.next = current.next;
		}
		return head;
	}

	public ListNode deleteAllOccurences(ListNode head, int data) {
		ListNode previous = null, next = head;
		while (next != null && next.data != data) {
			previous = next;
			next = next.next;
		}
		while (next != null && next.data == data) {
			next = next.next;
		}
		if (previous == null)
			return next;
		previous.next = next;
		return head;
	}

	public ListNode deleteNode(ListNode head, int position) {
		if (head == null)
			return null;
		if (position == 0)
			return head.next;
		int counter = 0;
		ListNode previousNode = head;
		while (previousNode != null && counter < position - 1) {
			previousNode = previousNode.next;
			counter++;
		}
		previousNode.next = previousNode.next.next;
		return head;
	}

	public ListNode reverseLinkedList(ListNode head, ListNode previous) {
		if (head == null)
			return previous;
		ListNode rev = reverseLinkedList(head.next, head);
		head.next = previous;
		return rev;
	}

	public ListNode reverseLinkedList2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode rev = reverseLinkedList2(head.next);
		head.next.next = head;
		head.next = null;
		return rev;
	}

	public ListNode reverseLinkedList_iteratively(ListNode head) {
		ListNode previous = null, next = null;
		while (head != null) {
			next = head.next;
			head.next = previous;
			previous = head;
			head = next;
		}
		return previous;
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

	// https://leetcode.com/problems/middle-of-the-linked-list/
	public ListNode getMiddle_ceil(ListNode head) {
		ListNode slowPointer = head, fasterPointer = head;
		while (fasterPointer != null && fasterPointer.next != null) {
			slowPointer = slowPointer.next;
			fasterPointer = fasterPointer.next.next;
		}
		return slowPointer;
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

	public ListNode getMiddle(ListNode head) {
		if (head == null)
			return head;

		ListNode slowPointer = head, fasterPointer = head;

		while (fasterPointer.next != null && fasterPointer.next.next != null) {
			slowPointer = slowPointer.next;
			fasterPointer = fasterPointer.next.next;
		}
		return slowPointer;
	}

	public static void main(String[] args) {
		Customized_LinkedList list = new Customized_LinkedList();
		ListNode head = null;
		head = list.insertNodeAtTail(head, 1);
		head = list.insertNodeAtTail(head, 2);
		head = list.insertNodeAtTail(head, 3);
		head = list.insertNodeAtTail(head, 4);
		System.out.println(list.deleteFirstOccurence(head, 1).data);
		// head = list.insertNodeAtTail(head, 5);
		// head = list.insertNodeAtTail(head, 4);
		// head = list.insertNodeAtTail(head, 4);
		// head = list.insertNodeAtTail(head, 5);
		// head = list.insertNodeAtTail(head, 6);
		// head = list.insertNodeAtTail(head, 7);
		// head = list.insertNodeAtTail(head, 4);
		// head = list.insertNodeAtTail(head, 5);
		// list.print(head);
		// list.printRecursively(head);
		// System.out.println("Length :- " + list.length(head));
		// list.printReverseRecursively(head);
		// System.out.println();
		// head = list.insertInSortedList(head, 100);
		// list.print(head);
		// head = list.deleteAllOccurences(head, 100);
		//
		// list.distinctElements(head);
		// list.print(head);

		// head = list.reverseLinkedList(head, null);
		// list.print(head);
		// head = list.distinctElements(head);
		list.print(head);
		System.out.println(list.getMiddle(head).data);
	}

}
