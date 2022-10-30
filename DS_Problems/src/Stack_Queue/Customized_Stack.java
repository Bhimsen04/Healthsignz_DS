package Stack_Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Customized_Stack {

	private int[] arr;
	private int currentIndex;
	private int capacity;

	public Customized_Stack(int capacity) {
		arr = new int[capacity];
		currentIndex = -1;
		this.capacity = capacity;
	}

	public void push(int n) {
		if (currentIndex >= arr.length - 1)
			growArray();
		arr[++currentIndex] = n;
	}

	private void growArray() {
		capacity = capacity * 2;
		int[] temp = new int[capacity];
		System.arraycopy(arr, 0, temp, 0, arr.length);
		arr = temp;
	}

	public void pop() {
		if (currentIndex >= 0) {
			System.out.println("Element " + arr[currentIndex] + " deleted Successfully");
			currentIndex--;
		} else
			System.err.println("Stack is Empty!!!");
	}

	public void peek() {
		if (currentIndex >= 0) {
			System.out.println("Element " + arr[currentIndex] + " getting Successfully");
		} else
			System.err.println("Stack is Empty!!!");
	}

	public void getAllElements() {
		Arrays.stream(arr).limit(currentIndex + 1).forEach(e -> System.out.print(e + " "));
		System.out.println();
	}

	public int size() {
		return currentIndex + 1;
	}

	public int capacity() {
		return capacity;
	}

	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack();
		System.out.println(s.pop());
		
		Customized_Stack stack = new Customized_Stack(5);
		stack.push(15);
		stack.push(25);
		stack.push(35);
		stack.push(45);
		stack.push(55);
		stack.push(65);
		stack.getAllElements();
		stack.pop();
		stack.peek();
		System.out.println("Total elemets in the stack :- " + stack.size());
		System.out.println("Total capacity of the stack :- " + stack.capacity());
	}

}
