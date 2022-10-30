package stack;

public class DynamicArray {
	protected int capacity; 					// length of array used to implement srack
	public static final int CAPACITY = 16; 		// default array capacity
	public static int MINCAPACITY = 1 << 15; 	// power of 2^15 * 1

	protected int[] stackRep; 					// array used to implement the stack

	protected int top = -1;  					// index of the top element  in the array
	
	public DynamicArray() {
		this(CAPACITY);
	}

	public DynamicArray(int cap) {
		capacity = cap;
		stackRep = new int[capacity];
	}
	
	public int size() {
		return top + 1 ;
	}
	
	public boolean isEmpty() {
		return top < 0 ;
	}
	
	private void push(int data) throws Exception{
		if(size() == capacity) {
			expand();
		}
		stackRep[++top] = data;
	}

	private void expand() {
		int length = size();
		int[] newStack = new int[length << 1];
		System.arraycopy(stackRep, 0, newStack, 0, length);
		stackRep = newStack;
		this.capacity = this.capacity << 1;
	}
	
	public int top() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is empty");
		return stackRep[top];
	}
	
	public int pop() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is empty");
		int data = stackRep[top];
		stackRep[top--] = Integer.MIN_VALUE;
		return data;
	}
	
}
