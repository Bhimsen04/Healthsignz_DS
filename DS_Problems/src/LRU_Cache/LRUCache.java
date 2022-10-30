package LRU_Cache;

import java.util.HashMap;

public class LRUCache {

	// https://leetcode.com/problems/lru-cache/
	int capacity;
	Node head = new Node(null, -1, -1, null);
	Node tail = new Node(null, -1, -1, null);

	HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	class Node {
		Node previous;
		int key;
		int value;
		Node next;

		public Node(Node previous, int key, int value, Node next) {
			this.previous = previous;
			this.key = key;
			this.value = value;
			this.next = next;
		}

	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node temp = map.get(key);
		Node newNode = commonCode(temp.key, temp.value, temp);
		map.put(key, newNode);
		return temp.value;
	}

	public void put(int key, int value) {
		Node newNode = null;
		if (map.size() < capacity && !map.containsKey(key)) {
			if (map.isEmpty())
				newNode = head.next = tail.previous = new Node(head, key, value, tail);
			else
				newNode = tail.previous.next = tail.previous = new Node(tail.previous, key, value, tail);
		}

		else if (map.size() >= capacity && !map.containsKey(key)) {
			Node temp = head.next;
			map.remove(temp.key);
			newNode = commonCode(key, value, temp);
		} else if (map.containsKey(key))
			newNode = commonCode(key, value, map.get(key));
		map.put(key, newNode);
	}

	public Node commonCode(int key, int value, Node temp) {
		temp.previous.next = temp.next;
		temp.next.previous = temp.previous;
		return tail.previous.next = tail.previous = new Node(tail.previous, key, value, tail);
	}

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(2, 1); // cache is {1=1}
		// lRUCache.put(1, 2); // cache is {1=1, 2=2}
		// lRUCache.print();
		System.out.println(lRUCache.get(1)); // return 1
		// lRUCache.print();
		// lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		// lRUCache.print();
		// System.out.println(lRUCache.get(2)); // returns -1 (not found)
		// lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		// System.out.println(lRUCache.get(1)); // return -1 (not found)
		// System.out.println(lRUCache.get(3)); // return 3
		// System.out.println(lRUCache.get(4)); // return 4
	}
}
