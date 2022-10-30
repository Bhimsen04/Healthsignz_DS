package Stack_Queue;

public class MyCircularQueue {
	// https://leetcode.com/problems/design-circular-queue/

	private int front;
	private int rear;
	private int[] ar;
	private int capacity;

	public MyCircularQueue(int capacity) {
		ar = new int[capacity];
		front = 0;
		rear = -1;
		this.capacity = capacity;
	}

	public boolean enQueue(int ele) {
		if (isFull())
			return false;
		ar[++rear % capacity] = ele;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty())
			return false;
		if (++front > rear) {
			front = 0;
			rear = -1;
		}
		return true;
	}

	public int Front() {
		return isEmpty() ? -1 : ar[front % capacity];
	}

	public int Rear() {
		return isEmpty() ? -1 : ar[rear % capacity];
	}

	public boolean isEmpty() {
		return rear == -1;
	}

	public boolean isFull() {
		return rear == -1 ? false : (rear + 1) % capacity == front % capacity;
	}

	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		myCircularQueue.enQueue(1); // return True
		myCircularQueue.enQueue(2); // return True
		myCircularQueue.enQueue(3); // return True
		myCircularQueue.enQueue(4); // return False
		myCircularQueue.Rear(); // return 3
		myCircularQueue.isFull(); // return True
		myCircularQueue.deQueue(); // return True
		myCircularQueue.enQueue(4); // return True
		myCircularQueue.Rear(); // return 4}
	}
}
