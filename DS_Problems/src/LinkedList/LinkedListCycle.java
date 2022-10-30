package LinkedList;

import LinkedList.SortLL.ListNode;

public class LinkedListCycle {

	// https://leetcode.com/problems/linked-list-cycle/

	public boolean hasCycle(ListNode head) {
		ListNode sp = head, fp = head;
		while (fp != null && fp.next != null) {
			sp = sp.next;
			fp = fp.next.next;
			if (fp == sp)
				return true;
		}
		return false;
	}
}
