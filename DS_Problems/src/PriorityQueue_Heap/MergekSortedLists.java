package PriorityQueue_Heap;

import java.util.PriorityQueue;

public class MergekSortedLists {

	// https://leetcode.com/problems/merge-k-sorted-lists/submissions/
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new MergekSortedListsComparator());
		for (ListNode node : lists)
			if (node != null)
				pq.offer(node);
		ListNode dummy = new ListNode();
		ListNode head = dummy;
		head.next = pq.peek();
		while (!pq.isEmpty()) {
			ListNode curr = pq.poll();
			if (curr.next != null)
				pq.offer(curr.next);
			dummy.next = curr;
			dummy = curr;
		}
		return head.next;
	}

	public class ListNode {
		int val;
		ListNode next;
	}

}
