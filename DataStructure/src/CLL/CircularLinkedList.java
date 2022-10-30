package CLL;

public class CircularLinkedList {

	protected CLLNode tail;
	protected int length;

	// adds element to head of list
	public void addToHead(int data) {
		CLLNode temp = new CLLNode(data);
		if (tail == null) { // first data added
			tail = temp;
			tail.setNext(tail);
		} else { // element exist in the list
			temp.setNext(tail.getNext());
			tail.setNext(temp);
		}
		length++;
	}

	// adds element to tail of list
	public void addToTail(int data) {
		addToHead(data);
		tail = tail.getNext();
	}

	// Returns data at the head of the list
	public int headPeek() {
		if (tail == null)
			return Integer.MIN_VALUE;
		return tail.getNext().getData();
	}

	// Returns data at the head of the list
	public int tailPeek() {
		if (tail == null)
			return Integer.MIN_VALUE;
		return tail.getData();
	}

	public int removeFromHead() {
		if (tail == null)
			return Integer.MIN_VALUE;
		else {
			CLLNode temp = tail.getNext();
			tail.setNext(temp.getNext());
			temp.setNext(null);
			length--;
			return temp.getData();
		}
	}

	public int removeFromTail() {
		if (tail == null)
			return Integer.MIN_VALUE;
		int data = tail.getData();
		if (length == 1)
			tail = null;
		else {
			CLLNode temp = tail;
			while (temp.getNext() != tail) 
				temp = temp.getNext();
			temp.setNext(tail.getNext());
			tail = temp;
		}
		length--;
		return data;
	}

	public String toString() {
		String result = "[";
		if (tail == null)
			;
		else {
			result = result + tail.getData();
			CLLNode temp = tail.getNext();
			while (temp != tail) {
				result += "," + temp.getData();
				temp = temp.getNext();
			}
		}
		return result + "]";
	}

	public static void main(String[] args) {
		CircularLinkedList cll = new CircularLinkedList();
		cll.addToHead(30);
		cll.addToHead(20);
		cll.addToHead(10);
		System.out.println(cll.toString() + " , " + cll.tail.getData());
		cll.addToTail(40);
		cll.addToTail(50);
		cll.addToTail(60);
		System.out.println(cll.toString() + " , " + cll.tail.getData() + " , " + cll.tail.getNext().getData());
		System.out.println("Removed head :- " + cll.removeFromHead());
		System.out.println(cll.toString() + " , " + cll.tail.getData() + " , " + cll.tail.getNext().getData());
		System.out.println("Removed tail :- " + cll.removeFromTail());
		System.out.println(cll.toString() + " , " + cll.tail.getData() + " , " + cll.tail.getNext().getData());
	}
}
