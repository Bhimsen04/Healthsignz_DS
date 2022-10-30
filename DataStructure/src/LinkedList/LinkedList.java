package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {

	ListNode head;
	private int length = 0;

	// Return first node in the list
	public synchronized ListNode getHead() {
		return head;
	}

	// Inserting a node at the beginning of the list
	public synchronized void insertAtBegin(ListNode node) {
		node.setNext(head);
		head = node;
		length++;
	}

	// Inserting a node at the end of the list
	public synchronized void insertAtEnd(ListNode node) {
		if (head == null)
			head = node;
		else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
		}
		length++;
	}

	// Add a new value to the list at a given position
	public synchronized void insert(int data, int position) {

		// fix the position
		if (position < 0)
			position = 0;
		else if (position > length)
			position = length;
		if (head == null)
			head = new ListNode(data);
		else if (position == 0) {
			ListNode temp = new ListNode(data);
			temp.setNext(head);
			head = temp;
		} else {
			ListNode temp = head;
			for (int i = 0; i < length; i++)
				temp = temp.getNext();
			ListNode newNode = new ListNode(data);
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		length++;
	}

	// Remove and return the node at the head of the list

	public synchronized ListNode removeFromBegin() {
		ListNode node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}

	// Remove and return the node at the head of the list
	public synchronized ListNode removeFromEnd() {
		if (head == null)
			return null;
		ListNode next = head.getNext();
		if (next == null) {
			head = null;
			return head;
		} else {
			ListNode current = next, previous = head;
			while ((next = current.getNext()) != null) {
				previous = current;
				current = next;
			}
			previous.setNext(null);
			return current;
		}

	}

	// Remove the value at a given position
	public void remove(int position) {
		if (head == null)
			return;
		else if (position < 0)
			position = 0;
		else if (position >= length)
			position = length - 1;
		if (position == 0) {
			head = head.getNext();
		} else {
			ListNode temp = head;
			for (int i = 1; i < position; i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		length--;
	}

	public int length() {
		return length;
	}

	public void clearList() {
		head = null;
		length = 0;
	}

	// Returning a string representation of this collection
	public String toString() {
		String result = "[";
		if (head == null)
			return result + "]";
		result = result + head.getData();
		ListNode temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode listNode = new ListNode(30);
		list.insertAtBegin(listNode);
		listNode = new ListNode(20);
		list.insertAtBegin(listNode);
		listNode = new ListNode(10);
		list.insertAtBegin(listNode);
		listNode = new ListNode(2);
		list.insertAtEnd(listNode);
		list.insert(2, 0);
		list.insert(20, 0);
		System.out.println(list.toString());
		list.removeDuplicate();
		System.out.println(list.toString());
	}

	public void removeDuplicate() {
		if (head == null || head.getNext() == null)
			return;
		Map<Integer, Boolean> mapper = new HashMap<Integer, Boolean>();
		ListNode current = head;
		ListNode prev = null;
		while (current != null) {
			if (mapper.get(current.getData()) != null)
				prev.setNext(current.getNext());
			else
				mapper.put(current.getData(), true);
			prev = current;
			current = current.getNext();
		}
	}
}
