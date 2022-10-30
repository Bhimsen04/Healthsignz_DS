package LinkedList;

import java.util.HashSet;

import LinkedList.SortLL.ListNode;

public class MergedPointsInLL {

	// https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
	public static void main(String[] args) {
		getIntersectionNode_hashSet(null, null);
		getIntersectionNode(null, null);
	}

	public static ListNode getIntersectionNode(ListNode A, ListNode B) {
		int length1 = length(A);
		int length2 = length(B);
		if (length1 < length2) {
			int n = length2 - length1;
			while (n-- > 0)
				B = B.next;
		} else if (length1 > length2) {
			int n = length1 - length2;
			while (n-- > 0)
				A = A.next;
		}
		while (A != null && B != null) {
			if (A == B)
				return A;
			A = A.next;
			B = B.next;
		}
		return null;
	}

	public static int length(ListNode head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	private static ListNode getIntersectionNode_hashSet(ListNode A, ListNode B) {
		HashSet<ListNode> set = new HashSet<>();
		while (A != null && B != null) {
			if (A == B || set.contains(A))
				return A;
			if (set.contains(B))
				return B;
			set.add(A);
			set.add(B);
			A = A.next;
			B = B.next;
		}
		while (A != null)
			if (set.contains(A))
				return A;
		while (B != null)
			if (set.contains(B))
				return B;
		return null;
	}

}
