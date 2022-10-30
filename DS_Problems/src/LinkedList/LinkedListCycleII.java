package LinkedList;

import LinkedList.SortLL.ListNode;

public class LinkedListCycleII {

	// leetcode.com/problems/linked-list-cycle-ii/submissions/
	public static void main(String[] args) {
		SortLL l = new SortLL();
		ListNode head = null;
		head = l.insertNodeAtHead(null, 1);
		l.print(head);
		System.out.println(detectCycle(head).data);
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode sp = head, fp = head;
		while (fp != null && fp.next != null) {
			sp = sp.next;
			fp = fp.next.next;
			if (fp == sp)
				break;
		}
		while (fp != null) {
			if (fp == head)
				return fp;
			fp = fp.next;
			head = head.next;
		}
		return null;
	}
}
