package LinkedList;

import LinkedList.SortLL.ListNode;

public class RemoveNthNodeFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int k) {
		// only for One node
		if (head == null || head.next == null)
			return null;
		ListNode slow = head, fast = head;
		while (k-- > 0)
			fast = fast.next;
		// only for remove first node
		if (fast == null)
			return head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		if (slow.next != null)
			slow.next = slow.next.next;
		return head;
	}
}
