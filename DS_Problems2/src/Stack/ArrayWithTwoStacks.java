package Stack;

import java.util.EmptyStackException;

public class ArrayWithTwoStacks {
	private int[] dataArray;
	private int size, topOne, topTwo;

	public ArrayWithTwoStacks(int size) {
		if (size < 2)
			throw new IllegalStateException("size<2 is not permissable");
		dataArray = new int[size];
		this.size = size;
		topOne = -1;
		topTwo = size;
	}

	public void push(int stackId, int value) {
		if (topOne + 1 >= topTwo)
			throw new StackOverflowError("Array if full");
		if (stackId == 1)
			dataArray[++topOne] = value;
		else if (stackId == 2)
			dataArray[--topTwo] = value;
	}

	public int pop(int stackId) {
		if (stackId == 1) {
			if (topOne < 0)
				throw new EmptyStackException();
			return dataArray[topOne--];
		} else if (stackId == 2) {
			if (topTwo == size)
				throw new EmptyStackException();
			return dataArray[topTwo++];
		}
		return -1;
	}
}
