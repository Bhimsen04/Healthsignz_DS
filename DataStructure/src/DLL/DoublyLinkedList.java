package DLL;

public class DoublyLinkedList {

	private DLLNode head;
	private DLLNode tail;
	private int length;

	public void insertHead(int newValue) {
		DLLNode newNode = new DLLNode(newValue, null, head);
		if (head == null)
			head = tail = newNode;
		else {
			head.setPrev(newNode);
			head = newNode;
		}
		length++;
	}

	public void insertTail(int newValue) {
		DLLNode newNode = new DLLNode(newValue, tail, null);
		if (head == null)
			head = tail = newNode;
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		length++;
	}

	public void insert(int data, int position) {
		if (position <= 0) {
			insertHead(data);
		} else if (position >= length) {
			insertTail(data);
		} else {
			DLLNode temp = null;
			if (position <= length / 2) {
				temp = head;
				for (int i = 1; i < position; i++) {
					temp = temp.getNext();
				}
				DLLNode newNode = new DLLNode(data, temp, temp.getNext());
				temp.getNext().setPrev(newNode);
				temp.setNext(newNode);
			} else {
				temp = tail;
				for (int i = length - 1; i > position; i--) {
					temp = tail.getPrev();
				}
				DLLNode newNode = new DLLNode(data, temp.getPrev(), temp);
				temp.getPrev().setNext(newNode);
				temp.setPrev(newNode);
			}
			length++;
		}

	}

	public int removeHead() {
		int data = Integer.MIN_VALUE;
		if (length == 0)
			;
		else if (head == tail) {
			data = head.getData();
			head = tail = null;
			length--;
		} else {
			data = head.getData();
			DLLNode temp = head.getNext();
			temp.setPrev(null);
			head.setNext(null);
			head = temp;
			length--;
		}
		return data;
	}

	public int removeTail() {
		int data = Integer.MIN_VALUE;
		if (length == 0)
			;
		else if (head == tail) {
			data = head.getData();
			head = tail = null;
			length--;
		} else {
			data = tail.getData();
			DLLNode temp = tail.getPrev();
			temp.setNext(null);
			tail.setPrev(null);
			tail = temp;
			length--;
		}
		return data;

	}

	public void remove(int position) {
		if (position <= 0)
			removeHead();
		else if (position >= length - 1)
			removeTail();
		else {
			if (position <= length / 2) {
				DLLNode deletePrevNode = head;
				for (int i = 1; i < position; i++) {
					deletePrevNode = deletePrevNode.getNext();
				}
				DLLNode deleteNextNode = deletePrevNode.getNext().getNext();
				deleteNextNode.setPrev(deletePrevNode);
				deletePrevNode.setNext(deleteNextNode);
			} else {
				DLLNode deleteNextNode = tail;
				for (int i = length - 1; i > position + 1; i--) {
					deleteNextNode = deleteNextNode.getPrev();
				}
				DLLNode deletePrevNode = deleteNextNode.getPrev().getPrev();
				deletePrevNode.setNext(deleteNextNode);
				deleteNextNode.setPrev(deletePrevNode);
			}
			length--;
		}

	}

	@Override
	public String toString() {
		String res = "[";
		if (head == null)
			return res += "]";
		res += head.getData();
		DLLNode temp = head.getNext();
		while (temp != null) {
			res += "," + temp.getData();
			temp = temp.getNext();
		}
		return res += "]";
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertHead(70);
		dll.insertHead(60);
		dll.insertHead(50);
		dll.insertHead(40);
		dll.insertHead(30);
		dll.insertHead(20);
		dll.insertHead(10);

		System.out.println(dll.toString());
		dll.remove(6);
		System.out.println(dll.toString());
		System.out.println("Head value:- " + dll.head.getData() + " , Tail value:- " + dll.tail.getData());
	}
}
