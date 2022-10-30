package Stack_Queue;

public class Customized_Queue {

	private int front, rear, capacity;
	private Object[] ar;

	public Customized_Queue(int capacity) {
		ar = new Object[capacity];
		front = 0;
		rear = -1;
		this.capacity = capacity;
	}

	public boolean isEmpty() {
		return rear == -1;
	}

	public boolean isFull() {
		return rear == -1 ? false : (rear + 1) % capacity == front % capacity;
	}

	public int size() {
		return rear - front + 1;
	}

	public Object Front() {
		return isEmpty() ? -1 : ar[front % capacity];
	}

	public Object Rear() {
		return isEmpty() ? -1 : ar[rear % capacity];
	}

	public void enQueue(Object ele) {
		if (isFull())
			System.out.println("Queue is Full");
		ar[++rear % capacity] = ele;
	}

	public Object deQueue() {
		if (isEmpty())
			return "Queue is Empty";
		Object ele = ar[front++ % capacity];
		if (front > rear) {
			front = 0;
			rear = -1;
		}
		return ele;

	}

	public static void main(String[] args) {
		Customized_Queue queue = new Customized_Queue(7);
		// System.out.println(queue.size());
		// System.out.println(queue.isEmpty());
		// System.out.println(queue.isFull());
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		System.out.println("Size :- " + queue.size());
		System.out.println("Is empty :- " + queue.isEmpty());
		System.out.println("Is full :- " + queue.isFull());

		System.out.println("Dequeue :- " + queue.deQueue());
		System.out.println("Dequeue :- " + queue.deQueue());
		System.out.println("Dequeue :- " + queue.deQueue());

		System.out.println("Size :- " + queue.size());
		System.out.println("Is empty :- " + queue.isEmpty());
		System.out.println("Is full :- " + queue.isFull());

		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);

		System.out.println("Size :- " + queue.size());
		System.out.println("Is empty :- " + queue.isEmpty());
		System.out.println("Is full :- " + queue.isFull());

		System.out.println("Dequeue :- " + queue.deQueue());
		System.out.println("Dequeue :- " + queue.deQueue());
		System.out.println("Dequeue :- " + queue.deQueue());
		System.out.println("Dequeue :- " + queue.deQueue());
		System.out.println("Dequeue :- " + queue.deQueue());
		System.out.println("Dequeue :- " + queue.deQueue());
		System.out.println("Dequeue :- " + queue.deQueue());

		System.out.println("Size :- " + queue.size());
		System.out.println("Is empty :- " + queue.isEmpty());
		System.out.println("Is full :- " + queue.isFull());
	}
}
