package LinkedList;

public class Problem4_ReverseLL_InPairs {
	static ListNode head = null;

	public static void main(String[] args) {
		Problem4_ReverseLL_InPairs obj = new Problem4_ReverseLL_InPairs();
		LinkedList list = new LinkedList();
		ListNode listNode = new ListNode(130);
		list.insertAtBegin(listNode);
		listNode = new ListNode(90);
		list.insertAtBegin(listNode);
		listNode = new ListNode(10);
		list.insertAtBegin(listNode);
		list.insert(8, 0);
		list.insert(5, 0);
		head = list.getHead();
		System.out.println(list.toString());
		ListNode temp2 = reverseLinkedListInPairs_Recursion(head);
		while (temp2 != null) {
			System.out.print(temp2.getData() + ",");
			temp2 = temp2.getNext();
		}
	}

	private static void reverseLinkedListInPairs(ListNode head) {
		ListNode head2 = null;
		ListNode tmp = head.getNext();
		while (head != null && (head2 = head.getNext()) != null) {
			ListNode temp = head2.getNext();
			head2.setNext(head);
			if (temp != null && temp.getNext() != null)
				head.setNext(temp.getNext());
			else
				head.setNext(temp);
			head = temp;
		}
		while (tmp != null) {
			System.out.print(tmp.getData() + ",");
			tmp = tmp.getNext();
		}
	}

	private static void reverseLinkedListInPairs2(ListNode head) {
		ListNode temp = null, temp2 = null;
		while (head != null && head.getNext() != null) {
			if (temp != null) {
				temp.getNext().setNext(head.getNext());
			}
			temp = head.getNext();
			head.setNext(temp.getNext());
			temp.setNext(head);
			if (temp2 == null)
				temp2 = temp;
			head = head.getNext();
		}
		while (temp2 != null) {
			System.out.print(temp2.getData() + ",");
			temp2 = temp2.getNext();
		}
	}

	private static ListNode reverseLinkedListInPairs_Recursion(ListNode head) {
		ListNode temp;
		if (head == null || head.getNext() == null) {
			return head;
		} else {
			temp = head.getNext();
			head.setNext(temp.getNext());
			temp.setNext(head);
			head = temp;
			head.getNext().setNext(reverseLinkedListInPairs_Recursion(head.getNext().getNext()));
			return head;
		}
	}
}
