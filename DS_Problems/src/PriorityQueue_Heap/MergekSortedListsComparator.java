package PriorityQueue_Heap;

import java.util.Comparator;

import PriorityQueue_Heap.MergekSortedLists.ListNode;

public class MergekSortedListsComparator implements Comparator<ListNode> {

	@Override
	public int compare(ListNode l1, ListNode l2) {
		return Integer.valueOf(l1.val).compareTo(l2.val);
	}

}
