package LinkedList;

public class Problem3_MergeTwoSortedList {
	static ListNode head1 = null;
	static ListNode head2 = null;

	public static void main(String[] args) {
		Problem3_MergeTwoSortedList obj = new Problem3_MergeTwoSortedList();
		LinkedList list = new LinkedList();
		ListNode listNode = new ListNode(130);
		list.insertAtBegin(listNode);
		listNode = new ListNode(90);
		list.insertAtBegin(listNode);
		listNode = new ListNode(10);
		list.insertAtBegin(listNode);
		list.insert(5, 0);
		head1 = list.getHead();
		System.out.println(list.toString());

		LinkedList list2 = new LinkedList();
		listNode = new ListNode(70);
		list2.insertAtBegin(listNode);
		listNode = new ListNode(60);
		list2.insertAtBegin(listNode);
		listNode = new ListNode(120);
		list2.insertAtEnd(listNode);
		list2.insert(15, 0);
		head2 = list2.getHead();
		System.out.println(list2.toString());

		ListNode node = obj.mergeTwoList_Recursion2_Better(head1, head2);
		while (node != null) {
			System.out.print(node.getData() + ",");
			node = node.getNext();
		}
	}

	
	private ListNode mergeTwoList_Recursion2_Better(ListNode head1, ListNode head2) {

		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}
		ListNode head = new ListNode(0);
		if (head1.getData() <= head2.getData()) {
			head = head1;
			head.setNext(mergeTwoList_Recursion2_Better(head1.getNext(), head2));
		} else {
			head = head2;
			head.setNext(mergeTwoList_Recursion2_Better(head2.getNext(), head1));
		}
		return head;
	}

	ListNode head = new ListNode(0);
	ListNode curr = head;

	private ListNode mergeTwoList_Recursion(ListNode head1, ListNode head2) {

		if (head1 == null) {
			curr.setNext(head2);
		} else if (head2 == null) {
			curr.setNext(head1);
		} else if (head1.getData() <= head2.getData()) {
			curr.setNext(head1);
			curr = head1;
			mergeTwoList_Recursion(head1.getNext(), head2);
		} else if (head1.getData() > head2.getData()) {
			curr.setNext(head2);
			curr = head2;
			mergeTwoList_Recursion(head2.getNext(), head1);
		}
		return head.getNext();
	}

	private static ListNode mergeTwoList(ListNode head1, ListNode head2) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		while (head1 != null && head2 != null) {
			if (head1.getData() <= head2.getData()) {
				curr.setNext(head1);
				curr = head1;
				head1 = head1.getNext();
			} else if (head1.getData() > head2.getData()) {
				curr.setNext(head2);
				curr = head2;
				head2 = head2.getNext();
			}
		}
		if (head1 != null) {
			curr.setNext(head1);
		} else if (head2 != null) {
			curr.setNext(head2);
		}
		return head.getNext();
	}
}
